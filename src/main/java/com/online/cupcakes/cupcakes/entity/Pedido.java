package com.online.cupcakes.cupcakes.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Pedido {

	private @Id @GeneratedValue Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private DadosPagamento dadosPagamento;
	
	@ManyToMany
	private List<Item> itens;
	
	private Double precoTotal;
	
	private String status;
	
	private String idTransacao;
	
	private Calendar dataCompra = Calendar.getInstance();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public DadosPagamento getDadosPagamento() {
		return dadosPagamento;
	}
	public void setDadosPagamento(DadosPagamento dadosPagamento) {
		this.dadosPagamento = dadosPagamento;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public Double getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdTransacao() {
		return idTransacao;
	}
	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}
	public Calendar getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}
	
}
