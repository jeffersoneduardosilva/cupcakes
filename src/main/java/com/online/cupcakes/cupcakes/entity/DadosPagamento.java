package com.online.cupcakes.cupcakes.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DadosPagamento {

	private @Id @GeneratedValue Long id;
	
	private String tipo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cartao cartao;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pix pix;
	
	private Boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public Pix getPix() {
		return pix;
	}
	public void setPix(Pix pix) {
		this.pix = pix;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
