package com.lojavirtual.lojavirtual.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lojavirtual.lojavirtual.entidades.ItemCarrinho;

public interface ItemCarrinhoRepositorio extends JpaRepository<ItemCarrinho, Long>{
	
	@Query("select new com.lojavirtual.lojavirtual.entidades.ItemCarrinho("
			+" ic.codigo, ic.produto, ic.carrinho, ic.quantidade, ic.preco)"																	
			+ "  from ItemCarrinho ic"
			+ " where ic.carrinho.codigo = :codigoCarrinho")
	List<ItemCarrinho> findByCarrinhoPorCodigo(Long codigoCarrinho);

}
