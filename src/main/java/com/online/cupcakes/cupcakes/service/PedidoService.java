package com.online.cupcakes.cupcakes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.online.cupcakes.cupcakes.controller.request.PedidoRequest;
import com.online.cupcakes.cupcakes.converter.PedidoConverter;
import com.online.cupcakes.cupcakes.entity.Cliente;
import com.online.cupcakes.cupcakes.entity.Item;
import com.online.cupcakes.cupcakes.entity.Pedido;
import com.online.cupcakes.cupcakes.entity.VendasSumario;
import com.online.cupcakes.cupcakes.repository.ClienteRepository;
import com.online.cupcakes.cupcakes.repository.ItemRepository;
import com.online.cupcakes.cupcakes.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private VendasSumarioService vendasSumarioService;
	
	public Pedido newPedido(@RequestBody PedidoRequest pedidoRequest) {
		
		VendasSumario vendasSumario = vendasSumarioService.getVendasSumario();
		
		PedidoConverter pedidoConverter = new PedidoConverter();
		Pedido converterToEntity = pedidoConverter.converterToEntity(pedidoRequest);
		
		Cliente cliente = converterToEntity.getCliente();
		Optional<Cliente> clieneByCpf = clienteRepository.getByCpf(cliente.getCpf());
		if(clieneByCpf.isPresent()) {
			Cliente clienteFound = clieneByCpf.get();
			
			//atualizando dados pessoais do cliente
			clienteFound.setNome(cliente.getNome());
			clienteFound.seteMail(cliente.geteMail());
			
			//atualizando dados do endereco do cliente
			clienteFound.getEndereco().setRua(cliente.getEndereco().getRua());
			clienteFound.getEndereco().setNumero(cliente.getEndereco().getNumero());
			clienteFound.getEndereco().setBairro(cliente.getEndereco().getBairro());
			clienteFound.getEndereco().setCidade(cliente.getEndereco().getCidade());
			clienteFound.getEndereco().setUf(cliente.getEndereco().getUf());
			
			converterToEntity.setCliente(clienteFound);
		}else {
			vendasSumario.setTotalClientes(vendasSumario.getTotalClientes() + 1);
		}
		
		vendasSumario.setTotalVendas(vendasSumario.getTotalVendas() + 1);
		vendasSumario.setTotalItensVendido(vendasSumario.getTotalItensVendido() + converterToEntity.getItens().size());
		vendasSumario.setTotalItensEstoque(vendasSumario.getTotalItensEstoque() - converterToEntity.getItens().size());
		
		Double totalVendasSumario = vendasSumario.getTotalValor() + converterToEntity.getPrecoTotal();
		vendasSumario.setTotalValor(totalVendasSumario);
		
		vendasSumarioService.updateVendasSumario(vendasSumario);
		
		//retira itens vendidos do estoque
		converterToEntity.getItens().forEach(item -> decreaseTotalitens(item));
		
		return pedidoRepository.save(converterToEntity);
	}
	
	private void decreaseTotalitens(Item item) {
		item.setQuantidadeEstoque(item.getQuantidadeEstoque() - 1);
		itemRepository.save(item);
	}
	
}
