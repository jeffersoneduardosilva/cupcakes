package com.online.cupcakes.cupcakes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cartao {
	
	private @Id @GeneratedValue Long id;
	
	private Long numero;
	private String nome;
	private Long codigoSeguranca;
	private Long mesValidade;
	private Long anoValidade;
	private Long ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(Long codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public Long getMesValidade() {
		return mesValidade;
	}
	public void setMesValidade(Long mesValidade) {
		this.mesValidade = mesValidade;
	}
	public Long getAnoValidade() {
		return anoValidade;
	}
	public void setAnoValidade(Long anoValidade) {
		this.anoValidade = anoValidade;
	}
	public Long getAtivo() {
		return ativo;
	}
	public void setAtivo(Long ativo) {
		this.ativo = ativo;
	}

}
