package com.lojavirtual.lojavirtual.dto.carrinho;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens do carrinho requisicao DTO")
public class ItemCarrinhoRequestDTO {
	
	@ApiModelProperty(value = "Código do Produto")
	@NotNull(message = "Código produto")
	private Long codigoProduto;
	
	@ApiModelProperty(value = "Quantidade")
	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;
	
	@ApiModelProperty(value = "Preco")
	@NotNull(message = "Preco")
	private BigDecimal preco;

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
