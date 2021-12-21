package com.lojavirtual.lojavirtual.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lojavirtual.lojavirtual.entidades.Produto;
import com.lojavirtual.lojavirtual.excecao.RegraNegocioException;
import com.lojavirtual.lojavirtual.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	public List<Produto> listarTodos() {
		return produtoRepositorio.findAll();
	}

	public Optional<Produto> buscarPorCodigo(Long codigo) {
		return produtoRepositorio.findById(codigo);
	}

	public Produto salvar(Produto produto) {
		validarProdutoDuplicado(produto);
		return produtoRepositorio.save(produto);
	}

	public Produto atualizar(Long codigo, Produto produto) {
		Produto produtoSalvar = validarProdutoExiste(codigo);
		validarProdutoDuplicado(produto);
		BeanUtils.copyProperties(produto, produtoSalvar, "codigo");
		return produtoRepositorio.save(produtoSalvar);
	}

	public void deletar(Long codigo) {
		produtoRepositorio.deleteById(codigo);
	}
	
	protected void atualizarQuantidadeEmEstoque(Produto produto) {
		produtoRepositorio.save(produto);
	}
	
	protected Produto validarProdutoExisteC(Long codigoProduto) {
		Optional<Produto> produto = produtoRepositorio.findById(codigoProduto);
		if (produto.isEmpty()) {
			throw new RegraNegocioException(String.format("Produto de código %s não encontrado", codigoProduto));
		}
		return produto.get();
	}
	
	private Produto validarProdutoExiste(Long codigo) {
		Optional<Produto> produto = buscarPorCodigo(codigo);
		if (produto.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return produto.get();
	}

	private void validarProdutoDuplicado(Produto produto) {
		Produto produtoEncontrado = produtoRepositorio.findByDescricao(produto.getDescricao());
		if (produtoEncontrado != null && produtoEncontrado.getCodigo() != produto.getCodigo()) {
			throw new RegraNegocioException(
					String.format("O produto %s já foi cadastrado", produto.getDescricao().toUpperCase()));
		}
	}

}
