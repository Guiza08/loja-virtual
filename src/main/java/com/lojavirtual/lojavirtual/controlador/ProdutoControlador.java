package com.lojavirtual.lojavirtual.controlador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.lojavirtual.lojavirtual.dto.ProdutoResponseDTO;
import com.lojavirtual.lojavirtual.dto.ProdutoRequestDTO;
import com.lojavirtual.lojavirtual.entidades.Produto;
import com.lojavirtual.lojavirtual.servico.ProdutoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produto")
@RestController
@RequestMapping("/Produto")
public class ProdutoControlador {

	@Autowired
	private ProdutoServico produtoServico;

	@ApiOperation(value = "Listar")
	@GetMapping
	public List<ProdutoResponseDTO> listarTodos() {
		return produtoServico.listarTodos().stream().map(produto -> ProdutoResponseDTO.converterParaProdutoDto(produto))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Listar por Codigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoResponseDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Produto> produto = produtoServico.buscarPorCodigo(codigo);
		return produto.isPresent() ? ResponseEntity.ok(ProdutoResponseDTO.converterParaProdutoDto(produto.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar")
	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> salvar(@Valid @RequestBody ProdutoRequestDTO produtoDto) {
		Produto produtoSalvo = produtoServico.salvar(produtoDto.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoResponseDTO.converterParaProdutoDto(produtoSalvo));
	}

	@ApiOperation(value = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long codigo, @Valid @RequestBody ProdutoRequestDTO produtoDto) {
		Produto produtoAtualizado = produtoServico.atualizar(codigo, produtoDto.converterParaEntidade(codigo));
		return ResponseEntity.ok(ProdutoResponseDTO.converterParaProdutoDto(produtoAtualizado));
	}

	@ApiOperation(value = "Deletar")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		produtoServico.deletar(codigo);
	}
}
