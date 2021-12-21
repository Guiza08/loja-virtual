package com.lojavirtual.lojavirtual.dto.carrinho;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Itens Carrinho retorno DTO")
public class ItemCarrinhoResponseDTO {
	
	@ApiModelProperty(value = "Codigo")
	private Long codigo;
	
	@ApiModelProperty(value = "Quantidade")
	private Integer quantidade;
	
	@ApiModelProperty(value = "Preco")
	private BigDecimal preco;
	
	@ApiModelProperty(value = "Codigo Produto")
	private Long codigoProduto;
	
	@ApiModelProperty(value = "Descricao Produto")
	private String produtoDescricao;

	public ItemCarrinhoResponseDTO(Long codigo, Integer quantidade, BigDecimal preco, Long codigoProduto,
			String produtoDescricao) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.preco = preco;
		this.codigoProduto = codigoProduto;
		this.produtoDescricao = produtoDescricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

}
