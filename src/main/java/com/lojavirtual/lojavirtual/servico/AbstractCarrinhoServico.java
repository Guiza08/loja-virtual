package com.lojavirtual.lojavirtual.servico;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.lojavirtual.lojavirtual.dto.carrinho.CarrinhoResponseDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.ClienteCarrinhoResponseDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.ItemCarrinhoRequestDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.ItemCarrinhoResponseDTO;
import com.lojavirtual.lojavirtual.entidades.Carrinho;
import com.lojavirtual.lojavirtual.entidades.ItemCarrinho;
import com.lojavirtual.lojavirtual.entidades.Produto;

public abstract class AbstractCarrinhoServico {
	
	protected ClienteCarrinhoResponseDTO retornandoClienteCarrinhoResponseDTO(Carrinho carrinho,
			List<ItemCarrinho> itensCarrinhoList) {
		return new ClienteCarrinhoResponseDTO(carrinho.getCliente().getNome(),
				Arrays.asList(criandoCarrinhoResponseDTO(carrinho, itensCarrinhoList)));
	}
	
	protected CarrinhoResponseDTO criandoCarrinhoResponseDTO(Carrinho carrinho, List<ItemCarrinho> itensCarrinhoList) {
		List<ItemCarrinhoResponseDTO> itensCarrinhoResponseDto = itensCarrinhoList
				.stream().map(this::criandoItensCarrinhoResponseDto).collect(Collectors.toList());
		return new CarrinhoResponseDTO(carrinho.getCodigo(), carrinho.getData(), itensCarrinhoResponseDto);		
	}

	protected ItemCarrinhoResponseDTO criandoItensCarrinhoResponseDto(ItemCarrinho itemCarrinho) {
		return new ItemCarrinhoResponseDTO(itemCarrinho.getCodigo(), itemCarrinho.getQuantidade(),
				itemCarrinho.getPreco(), itemCarrinho.getProduto().getCodigo(),
				itemCarrinho.getProduto().getDescricao());
	}
	
	protected ItemCarrinho criandoItemCarrinho(ItemCarrinhoRequestDTO itemCarrinhoDto, Carrinho carrinho) {
		return new ItemCarrinho(new Produto(itemCarrinhoDto.getCodigoProduto()), carrinho,
				itemCarrinhoDto.getQuantidade(), itemCarrinhoDto.getPreco());
	}

}
