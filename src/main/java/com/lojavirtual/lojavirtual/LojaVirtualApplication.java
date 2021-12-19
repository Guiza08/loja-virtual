package com.lojavirtual.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.lojavirtual.lojavirtual.entidades"})
@EnableJpaRepositories(basePackages = {"com.lojavirtual.lojavirtual.repositorio"})
@ComponentScan(basePackages = {"com.lojavirtual.lojavirtual.servico", "com.lojavirtual.lojavirtual.controlador", "com.lojavirtual.lojavirtual.excecao"})
@SpringBootApplication
public class LojaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaVirtualApplication.class, args);
	}

}
