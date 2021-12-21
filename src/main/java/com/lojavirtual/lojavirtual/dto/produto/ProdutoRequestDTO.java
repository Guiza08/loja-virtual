package com.lojavirtual.lojavirtual.dto.produto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.lojavirtual.lojavirtual.entidades.Produto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Produto resquisicão DTO")
public class ProdutoRequestDTO {
	
	@ApiModelProperty("Descricao")
	@NotBlank(message = "descricao")
	@Length(min = 3, max = 100, message = "descricao")
	private String descricao;

	@ApiModelProperty(value = "Quantidade")
	@NotBlank(message = "quantidade")
	private Integer quantidade;

	@ApiModelProperty(value = "Preco")
	@NotBlank(message = "preco")
	private BigDecimal preco;

	@ApiModelProperty(value = "Observacao")
	@Length(min = 3, max = 500, message = "observacao")
	private String observacao;
	
	public Produto converterParaEntidade() {
		return new Produto(descricao, quantidade, preco, observacao);
	}
	
	public Produto converterParaEntidade(Long codigo) {
		return new Produto(codigo, descricao, quantidade, preco, observacao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
