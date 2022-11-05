package com.online.cupcakes.cupcakes.controller.request;

import java.io.Serializable;
import java.util.List;

import com.online.cupcakes.cupcakes.entity.Item;

public class PedidoRequest implements Serializable{
	
	private static final long serialVersionUID = 6893587275503425010L;
	
	private String idTransacao;
	
	//dados pessoais do cliente
	private String nome;
	private String eMail;
	private String cpf;
	
	//dados do endereco do cliente
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String numero;
	
	//dados do cartao para pagamento
	private Long numeroCartao;
	private String nomeCartao;
	private Long codigoSeguranca;
	private Long mesValidade;
	private Long anoValidade;
	private Long ativo;
	
	//itens para pedido
	private List<Item> itens;
	
	//preco total do pedido
	private Double precoTotal;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
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

	public String getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}
	
}
