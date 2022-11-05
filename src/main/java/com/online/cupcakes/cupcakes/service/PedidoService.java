package com.online.cupcakes.cupcakes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.online.cupcakes.cupcakes.controller.request.PedidoRequest;
import com.online.cupcakes.cupcakes.converter.PedidoConverter;
import com.online.cupcakes.cupcakes.entity.Cliente;
import com.online.cupcakes.cupcakes.entity.Pedido;
import com.online.cupcakes.cupcakes.repository.ClienteRepository;
import com.online.cupcakes.cupcakes.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Pedido newPedido(@RequestBody PedidoRequest pedidoRequest) {
		
		PedidoConverter pedidoConverter = new PedidoConverter();
		Pedido converterToEntity = pedidoConverter.converterToEntity(pedidoRequest);
		
		Cliente cliente = converterToEntity.getCliente();
		Optional<Cliente> clieneByCpf = clienteRepository.getByCpf(cliente.getCpf());
		if(clieneByCpf.isPresent()) {
			converterToEntity.setCliente(clieneByCpf.get());
		}
		
		return pedidoRepository.save(converterToEntity);
	}
	
}
