package com.online.cupcakes.cupcakes.converter;

import com.online.cupcakes.cupcakes.controller.request.PedidoRequest;
import com.online.cupcakes.cupcakes.entity.Cartao;
import com.online.cupcakes.cupcakes.entity.Cliente;
import com.online.cupcakes.cupcakes.entity.DadosPagamento;
import com.online.cupcakes.cupcakes.entity.Endereco;
import com.online.cupcakes.cupcakes.entity.Pedido;

public class PedidoConverter {

	public Pedido converterToEntity(PedidoRequest pedidoRequest) {
		
		Pedido pedido = new Pedido();
		pedido.setItens(pedidoRequest.getItens());
		pedido.setIdTransacao(pedidoRequest.getIdTransacao());
		
		pedido.setPrecoTotal(pedidoRequest.getPrecoTotal());
		
		Cliente cliente = new Cliente();
		cliente.setCpf(pedidoRequest.getCpf());
		cliente.seteMail(pedidoRequest.geteMail());
		cliente.setNome(pedidoRequest.getNome());
		
		Endereco endereco = new Endereco();
		endereco.setBairro(pedidoRequest.getBairro());
		endereco.setCidade(pedidoRequest.getCidade());
		endereco.setNumero(pedidoRequest.getNumero());
		endereco.setRua(pedidoRequest.getRua());
		endereco.setUf(pedidoRequest.getUf());
		cliente.setEndereco(endereco);
		
		pedido.setCliente(cliente);
		
		DadosPagamento dadosPagamento = new DadosPagamento();
		
		Cartao cartao = new Cartao();
		cartao.setAnoValidade(pedidoRequest.getAnoValidade());
		cartao.setCodigoSeguranca(pedidoRequest.getCodigoSeguranca());
		cartao.setMesValidade(pedidoRequest.getMesValidade());
		cartao.setNome(pedidoRequest.getNomeCartao());
		cartao.setNumero(pedidoRequest.getNumeroCartao());
		dadosPagamento.setCartao(cartao);
		
		pedido.setDadosPagamento(dadosPagamento);
		
		pedido.setStatus("Pedido confirmado");
		
		return pedido;
	}
	
}
