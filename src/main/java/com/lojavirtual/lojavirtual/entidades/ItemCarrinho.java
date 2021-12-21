package com.lojavirtual.lojavirtual.entidades;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_carrinho")
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")
	private Produto produto;
	
	@OneToOne
	@JoinColumn(name = "codigo_carrinho", referencedColumnName = "codigo")
	private Carrinho carrinho;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	public ItemCarrinho() {
		
	}
	
	public ItemCarrinho(Long codigo, Produto produto, Carrinho carrinho, Integer quantidade, BigDecimal preco) {
		this.codigo = codigo;
		this.produto = produto;
		this.carrinho = carrinho;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ItemCarrinho(Produto produto, Carrinho carrinho, Integer quantidade, BigDecimal preco) {
		this.produto = produto;
		this.carrinho = carrinho;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
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

	@Override
	public int hashCode() {
		return Objects.hash(carrinho, codigo, preco, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ItemCarrinho)) {
			return false;
		}
		ItemCarrinho other = (ItemCarrinho) obj;
		return Objects.equals(carrinho, other.carrinho) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(preco, other.preco) && Objects.equals(produto, other.produto)
				&& Objects.equals(quantidade, other.quantidade);
	}
	
}
