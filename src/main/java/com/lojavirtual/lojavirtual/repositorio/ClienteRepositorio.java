package com.lojavirtual.lojavirtual.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojavirtual.lojavirtual.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
	
	Cliente findByNome(String nome);
	
}
