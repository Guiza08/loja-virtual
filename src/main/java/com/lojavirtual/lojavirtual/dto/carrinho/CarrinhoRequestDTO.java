package com.lojavirtual.lojavirtual.dto.carrinho;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Carrinho requisicao Dto")
public class CarrinhoRequestDTO {
	
	@ApiModelProperty(value = "Data")
	@NotNull(message = "Data")
	private LocalDate data;
	
	@ApiModelProperty(value = "Item do Carrinho")
	@NotNull(message = "Item carrinho")
	@Valid
	private List<ItemCarrinhoRequestDTO> itemCarrinhoDto;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemCarrinhoRequestDTO> getItemCarrinhoDto() {
		return itemCarrinhoDto;
	}

	public void setItemCarrinhoDto(List<ItemCarrinhoRequestDTO> itemCarrinhoDto) {
		this.itemCarrinhoDto = itemCarrinhoDto;
	}

}
