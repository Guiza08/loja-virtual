package com.lojavirtual.lojavirtual.dto.carrinho;

import java.time.LocalDate;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Venda retorno DTO")
public class CarrinhoResponseDTO {
	
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Data")
	private LocalDate data;
	
	@ApiModelProperty(value = "Itens do Carrinho")
	private List<ItemCarrinhoResponseDTO> itemCarrinhoDTO;

	public CarrinhoResponseDTO(Long codigo, LocalDate data, List<ItemCarrinhoResponseDTO> itemCarrinhoDTO) {
		this.codigo = codigo;
		this.data = data;
		this.itemCarrinhoDTO = itemCarrinhoDTO;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemCarrinhoResponseDTO> getItemCarrinhoDTO() {
		return itemCarrinhoDTO;
	}

	public void setItemCarrinhoDTO(List<ItemCarrinhoResponseDTO> itemCarrinhoDTO) {
		this.itemCarrinhoDTO = itemCarrinhoDTO;
	}

}
