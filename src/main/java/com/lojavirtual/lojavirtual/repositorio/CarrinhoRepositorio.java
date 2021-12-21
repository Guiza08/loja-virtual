package com.lojavirtual.lojavirtual.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.lojavirtual.entidades.Carrinho;

public interface CarrinhoRepositorio extends JpaRepository<Carrinho, Long>{
	
	List<Carrinho> findByClienteCodigo(Long codigoCliente);

}
