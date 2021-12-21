package com.lojavirtual.lojavirtual.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lojavirtual.lojavirtual.dto.carrinho.CarrinhoRequestDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.CarrinhoResponseDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.ClienteCarrinhoResponseDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.ItemCarrinhoRequestDTO;
import com.lojavirtual.lojavirtual.entidades.Carrinho;
import com.lojavirtual.lojavirtual.entidades.Cliente;
import com.lojavirtual.lojavirtual.entidades.ItemCarrinho;
import com.lojavirtual.lojavirtual.entidades.Produto;
import com.lojavirtual.lojavirtual.excecao.RegraNegocioException;
import com.lojavirtual.lojavirtual.repositorio.CarrinhoRepositorio;
import com.lojavirtual.lojavirtual.repositorio.ItemCarrinhoRepositorio;

@Service
public class CarrinhoServico extends AbstractCarrinhoServico {

	private CarrinhoRepositorio carrinhoRepositorio;
	private ItemCarrinhoRepositorio itemCarrinhoRepositorio;
	private ClienteServico clienteServico;
	private ProdutoServico produtoServico;

	@Autowired
	public CarrinhoServico(CarrinhoRepositorio carrinhoRepositorio, ItemCarrinhoRepositorio itemCarrinhoRepositorio,
			ClienteServico clienteServico, ProdutoServico produtoServico) {
		this.carrinhoRepositorio = carrinhoRepositorio;
		this.itemCarrinhoRepositorio = itemCarrinhoRepositorio;
		this.clienteServico = clienteServico;
		this.produtoServico = produtoServico;
	}

	public ClienteCarrinhoResponseDTO listarCarrinhoPorCliente(Long codigoCliente) {
		Cliente cliente = validarClienteCarrinhoExiste(codigoCliente);
		List<CarrinhoResponseDTO> carrinhoResponseDtoList = carrinhoRepositorio.findByClienteCodigo(codigoCliente)
				.stream()
				.map(carrinho -> criandoCarrinhoResponseDTO(carrinho,
						itemCarrinhoRepositorio.findByCarrinhoPorCodigo(carrinho.getCodigo())))
				.collect(Collectors.toList());
		return new ClienteCarrinhoResponseDTO(cliente.getNome(), carrinhoResponseDtoList);
	}

	public ClienteCarrinhoResponseDTO listarCarrinhoPorCodigo(Long codigoCarrinho) {
		Carrinho carrinho = validarCarrinhoExiste(codigoCarrinho);
		List<ItemCarrinho> itensCarrinhoList = itemCarrinhoRepositorio.findByCarrinhoPorCodigo(carrinho.getCodigo());
		return retornandoClienteCarrinhoResponseDTO(carrinho, itensCarrinhoList);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public ClienteCarrinhoResponseDTO salvar(Long codigoCliente, CarrinhoRequestDTO carrinhoDto) {
		Cliente cliente = validarClienteCarrinhoExiste(codigoCliente);
		validarProdutoExisteEAtualizarQuantidade(carrinhoDto.getItemCarrinhoDto());
		Carrinho carrinhoSalvo = salvarCarrinho(cliente, carrinhoDto);
		return retornandoClienteCarrinhoResponseDTO(carrinhoSalvo,
				itemCarrinhoRepositorio.findByCarrinhoPorCodigo(carrinhoSalvo.getCodigo()));
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void deletar(Long codigoCarrinho) {
		validarCarrinhoExiste(codigoCarrinho);
		List<ItemCarrinho> itensCarrinho = itemCarrinhoRepositorio.findByCarrinhoPorCodigo(codigoCarrinho);
		validarProdutoExisteEDevolverEstoque(itensCarrinho);
		itemCarrinhoRepositorio.deleteAll(itensCarrinho);
		carrinhoRepositorio.deleteById(codigoCarrinho);
	}

	public ClienteCarrinhoResponseDTO atualizar(Long codigoCarrinho, Long codigoCliente,
			CarrinhoRequestDTO carrinhoDto) {
		validarCarrinhoExiste(codigoCarrinho);
		Cliente cliente = validarClienteCarrinhoExiste(codigoCliente);
		List<ItemCarrinho> itensCarrinhoList = itemCarrinhoRepositorio.findByCarrinhoPorCodigo(codigoCarrinho);
		validarProdutoExisteEDevolverEstoque(itensCarrinhoList);
		validarProdutoExisteEAtualizarQuantidade(carrinhoDto.getItemCarrinhoDto());
		itemCarrinhoRepositorio.deleteAll(itensCarrinhoList);
		Carrinho carrinhoAtualizado = atualizarCarrinho(codigoCarrinho, cliente, carrinhoDto);
		return retornandoClienteCarrinhoResponseDTO(carrinhoAtualizado,
				itemCarrinhoRepositorio.findByCarrinhoPorCodigo(carrinhoAtualizado.getCodigo()));
	}

	private void validarProdutoExisteEDevolverEstoque(List<ItemCarrinho> itensCarrinho) {
		itensCarrinho.forEach(item -> {
			Produto produto = produtoServico.validarProdutoExisteC(item.getProduto().getCodigo());
			produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
			produtoServico.atualizarQuantidadeEmEstoque(produto);
		});
	}

	private void validarProdutoExisteEAtualizarQuantidade(List<ItemCarrinhoRequestDTO> itemCarrinhoDto) {
		itemCarrinhoDto.forEach(item -> {
			Produto produto = produtoServico.validarProdutoExisteC(item.getCodigoProduto());
			validarQuantidadeProdutoExiste(produto, item.getQuantidade());
			produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
			produtoServico.atualizarQuantidadeEmEstoque(produto);
		});
	}

	private void validarQuantidadeProdutoExiste(Produto produto, Integer qtdeCarrinhoDto) {
		if (!(produto.getQuantidade() >= qtdeCarrinhoDto)) {
			throw new RegraNegocioException(String.format("A quantidade %s irformada do produto %s não está disponível",
					qtdeCarrinhoDto, produto.getDescricao()));
		}
	}

	private Carrinho salvarCarrinho(Cliente cliente, CarrinhoRequestDTO carrinhoDto) {
		Carrinho carrinhoSalvo = carrinhoRepositorio.save(new Carrinho(carrinhoDto.getData(), cliente));
		carrinhoDto.getItemCarrinhoDto().stream()
				.map(itemCarrinhoDto -> criandoItemCarrinho(itemCarrinhoDto, carrinhoSalvo))
				.forEach(itemCarrinhoRepositorio::save);
		;
		return carrinhoSalvo;
	}

	private Carrinho atualizarCarrinho(Long codigoCarrinho, Cliente cliente, CarrinhoRequestDTO carrinhoDto) {
		Carrinho carrinhoSalvo = carrinhoRepositorio.save(new Carrinho(codigoCarrinho, carrinhoDto.getData(), cliente));
		carrinhoDto.getItemCarrinhoDto().stream()
				.map(itemCarrinhoDto -> criandoItemCarrinho(itemCarrinhoDto, carrinhoSalvo))
				.forEach(itemCarrinhoRepositorio::save);
		;
		return carrinhoSalvo;
	}

	private Carrinho validarCarrinhoExiste(Long codigoCarrinho) {
		Optional<Carrinho> carrinho = carrinhoRepositorio.findById(codigoCarrinho);
		if (carrinho.isEmpty()) {
			throw new RegraNegocioException(String.format("Carrinho de código %s não encontrada", codigoCarrinho));
		}
		return carrinho.get();
	}

	private Cliente validarClienteCarrinhoExiste(Long codigoCliente) {
		Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigoCliente);
		if (cliente.isEmpty()) {
			throw new RegraNegocioException(
					String.format("O Cliente de código %s informado não existe no cadastro", codigoCliente));
		}
		return cliente.get();
	}

}
