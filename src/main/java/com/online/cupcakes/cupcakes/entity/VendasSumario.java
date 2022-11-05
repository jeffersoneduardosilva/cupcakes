package com.online.cupcakes.cupcakes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VendasSumario {

	private @Id @GeneratedValue Long id;
	
	private String nomeRelatorio;
	private Integer totalVendas;
	private Integer totalItensVendido;
	private Integer totalClientes;
	private Double totalValor;
	private Integer totalItensEstoque;
	
	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(Integer totalVendas) {
		this.totalVendas = totalVendas;
	}

	public Integer getTotalClientes() {
		return totalClientes;
	}

	public void setTotalClientes(Integer totalClientes) {
		this.totalClientes = totalClientes;
	}

	public Double getTotalValor() {
		return totalValor;
	}

	public void setTotalValor(Double totalValor) {
		this.totalValor = totalValor;
	}

	public Integer getTotalItensEstoque() {
		return totalItensEstoque;
	}

	public void setTotalItensEstoque(Integer totalItensEstoque) {
		this.totalItensEstoque = totalItensEstoque;
	}

	public Integer getTotalItensVendido() {
		return totalItensVendido;
	}

	public void setTotalItensVendido(Integer totalItensVendido) {
		this.totalItensVendido = totalItensVendido;
	}
	
}
