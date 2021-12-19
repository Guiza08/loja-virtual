package com.lojavirtual.lojavirtual.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.lojavirtual.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
	
	Produto findByDescricao(String descricao);

}
