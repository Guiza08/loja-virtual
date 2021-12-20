package com.lojavirtual.lojavirtual.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.lojavirtual.lojavirtual.entidades.Cliente;
import com.lojavirtual.lojavirtual.entidades.Endereco;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente requisicao DTO")
public class ClienteRequestDTO {

	@ApiModelProperty(value = "Nome")
	@NotBlank(message = "Nome")
	@Length(min = 3, max = 50, message = "Nome")
	private String nome;

	@ApiModelProperty(value = "Telefone")
	@NotBlank(message = "Telefone")
	@Pattern(regexp = "\\([0-9]{2}\\)[0-9]{5}[- .][0-9]{4}", message = "Telefone")
	private String telefone;

	@ApiModelProperty(value = "Ativo")
	@NotNull(message = "Ativo")
	private Boolean ativo;

	@ApiModelProperty(value = "Endereco")
	@NotNull(message = "Endereco")
	@Valid
	private EnderecoRequestDTO enderecoRequestDto;

	public Cliente converterParaEntidade() {
		Endereco endereco = new Endereco(enderecoRequestDto.getLogradouro(), enderecoRequestDto.getNumero(),
				enderecoRequestDto.getComplemento(), enderecoRequestDto.getBairro(), enderecoRequestDto.getCep(),
				enderecoRequestDto.getCidade(), enderecoRequestDto.getEstado());
		return new Cliente(nome, telefone, ativo, endereco);
	}
	
	public Cliente converterParaEntidade(Long codigo) {
		Endereco endereco = new Endereco(enderecoRequestDto.getLogradouro(), enderecoRequestDto.getNumero(),
				enderecoRequestDto.getComplemento(), enderecoRequestDto.getBairro(), enderecoRequestDto.getCep(),
				enderecoRequestDto.getCidade(), enderecoRequestDto.getEstado());
		return new Cliente(codigo, nome, telefone, ativo, endereco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public EnderecoRequestDTO getEnderecoRequestDto() {
		return enderecoRequestDto;
	}

	public void setEnderecoRequestDto(EnderecoRequestDTO enderecoRequestDto) {
		this.enderecoRequestDto = enderecoRequestDto;
	}

}
