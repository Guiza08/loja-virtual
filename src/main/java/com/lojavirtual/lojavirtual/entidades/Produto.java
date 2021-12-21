package com.lojavirtual.lojavirtual.entidades;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
	private BigDecimal preco;

	@Column(name = "observacao")
	private String observacao;

	public Produto() {
	}
	
	public Produto(Long codigo) {
		this.codigo = codigo;
	}

	public Produto(String descricao, Integer quantidade, BigDecimal preco, String observacao) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.observacao = observacao;
	}

	public Produto(Long codigo, String descricao, Integer quantidade, BigDecimal preco, String observacao) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.observacao = observacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, observacao, preco, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(preco, other.preco)
				&& Objects.equals(quantidade, other.quantidade);
	}

}