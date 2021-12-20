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

import com.lojavirtual.lojavirtual.dto.ClienteRequestDTO;
import com.lojavirtual.lojavirtual.dto.ClienteResponseDTO;
import com.lojavirtual.lojavirtual.entidades.Cliente;
import com.lojavirtual.lojavirtual.servico.ClienteServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Cliente")
@RestController
@RequestMapping("/Cliente")
public class ClienteControlador {

	@Autowired
	private ClienteServico clienteServico;

	@ApiOperation(value = "Listar")
	@GetMapping
	public List<ClienteResponseDTO> listarTodos() {
		return clienteServico.ListarTodos().stream().map(cliente -> ClienteResponseDTO.converterParaClienteDTO(cliente))
				.collect(Collectors.toList());
	}

	@ApiOperation(value = "Listar por Codigo")
	@GetMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> buscarPorCodigo(@PathVariable Long codigo) {
		Optional<Cliente> cliente = clienteServico.buscarPorCodigo(codigo);
		return cliente.isPresent() ? ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(cliente.get()))
				: ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Salvar")
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
		Cliente clienteSalvo = clienteServico.salvar(clienteRequestDTO.converterParaEntidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.converterParaClienteDTO(clienteSalvo));
	}
	
	@ApiOperation(value = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
		Cliente clienteAtualizado = clienteServico.atualizar(codigo, clienteRequestDTO.converterParaEntidade(codigo));
		return ResponseEntity.ok(ClienteResponseDTO.converterParaClienteDTO(clienteAtualizado));
	}
	
	@ApiOperation(value = "Deletar")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		clienteServico.deletar(codigo);
	}

}
