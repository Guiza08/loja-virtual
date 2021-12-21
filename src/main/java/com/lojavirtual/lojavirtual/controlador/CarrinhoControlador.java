package com.lojavirtual.lojavirtual.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.lojavirtual.dto.carrinho.CarrinhoRequestDTO;
import com.lojavirtual.lojavirtual.dto.carrinho.ClienteCarrinhoResponseDTO;
import com.lojavirtual.lojavirtual.servico.CarrinhoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Carrinho")
@RestController
@RequestMapping("/carrinho")
public class CarrinhoControlador {

	@Autowired
	private CarrinhoServico carrinhoServico;

	@ApiOperation(value = "Listar carrinho por cliente")
	@GetMapping("/cliente/{codigoCliente}")
	public ResponseEntity<ClienteCarrinhoResponseDTO> listarCarrinhoPorCliente(@PathVariable Long codigoCliente) {
		return ResponseEntity.ok(carrinhoServico.listarCarrinhoPorCliente(codigoCliente));
	}

	@ApiOperation(value = "Listar carrinho por codigo")
	@GetMapping("/{codigoCarrinho}")
	public ResponseEntity<ClienteCarrinhoResponseDTO> listarCarrinhoPorCodigo(@PathVariable Long codigoCarrinho) {
		return ResponseEntity.ok(carrinhoServico.listarCarrinhoPorCodigo(codigoCarrinho));
	}

	@ApiOperation(value = "Salvar item carrinho")
	@PostMapping("/cliente/{codigoCliente}")
	public ResponseEntity<ClienteCarrinhoResponseDTO> salvar(@PathVariable Long codigoCliente,
			@Valid @RequestBody CarrinhoRequestDTO carrinhoDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoServico.salvar(codigoCliente, carrinhoDto));
	}

	@ApiOperation("Deletar item carrinho")
	@DeleteMapping("/{codigoCarrinho}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigoCarrinho) {
		carrinhoServico.deletar(codigoCarrinho);
	}

	@ApiOperation("Atualizar carrinho")
	@PutMapping("/{codigoCarrinho}/cliente/{codigoCliente}")
	public ResponseEntity<ClienteCarrinhoResponseDTO> atualizar(@PathVariable Long codigoCarrinho,
			@PathVariable Long codigoCliente, @Valid @RequestBody CarrinhoRequestDTO carrinhoDto) {
		return ResponseEntity.ok(carrinhoServico.atualizar(codigoCarrinho, codigoCliente, carrinhoDto));
	}

}
