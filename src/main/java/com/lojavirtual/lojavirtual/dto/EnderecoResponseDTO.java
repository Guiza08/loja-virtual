package com.lojavirtual.lojavirtual.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Endereco retorno DTO")
public class EnderecoResponseDTO {

	@ApiModelProperty(value = "Logradouro")
	private String logradouto;

	@ApiModelProperty(value = "Número")
	private Integer numero;

	@ApiModelProperty(value = "Complemento")
	private String complemento;

	@ApiModelProperty(value = "Bairro")
	private String bairro;

	@ApiModelProperty(value = "Cep")
	private String cep;

	@ApiModelProperty(value = "Cidade")
	private String cidade;

	@ApiModelProperty(value = "Estado")
	private String estado;

	public EnderecoResponseDTO(String logradouto, Integer numero, String complemento, String bairro, String cep,
			String cidade, String estado) {
		this.logradouto = logradouto;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouto() {
		return logradouto;
	}

	public void setLogradouto(String logradouto) {
		this.logradouto = logradouto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
