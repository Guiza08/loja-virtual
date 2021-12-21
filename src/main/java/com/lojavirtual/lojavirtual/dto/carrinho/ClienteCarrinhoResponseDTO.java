package com.lojavirtual.lojavirtual.dto.carrinho;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente do Carrinho Retorno DTO")
public class ClienteCarrinhoResponseDTO {
	
	@ApiModelProperty(value = "Cliente Venda")
	private String nome;
	
	@ApiModelProperty(value = "Venda")
	private List<CarrinhoResponseDTO> carrinhoResponseDto;

	public ClienteCarrinhoResponseDTO(String nome, List<CarrinhoResponseDTO> carrinhoResponseDto) {
		this.nome = nome;
		this.carrinhoResponseDto = carrinhoResponseDto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CarrinhoResponseDTO> getCarrinhoResponseDto() {
		return carrinhoResponseDto;
	}

	public void setCarrinhoResponseDto(List<CarrinhoResponseDTO> carrinhoResponseDto) {
		this.carrinhoResponseDto = carrinhoResponseDto;
	}

}
