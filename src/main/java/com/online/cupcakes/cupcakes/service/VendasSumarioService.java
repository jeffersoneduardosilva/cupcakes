package com.online.cupcakes.cupcakes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.online.cupcakes.cupcakes.controller.request.PedidoRequest;
import com.online.cupcakes.cupcakes.converter.PedidoConverter;
import com.online.cupcakes.cupcakes.entity.Cliente;
import com.online.cupcakes.cupcakes.entity.Pedido;
import com.online.cupcakes.cupcakes.entity.VendasSumario;
import com.online.cupcakes.cupcakes.repository.ClienteRepository;
import com.online.cupcakes.cupcakes.repository.PedidoRepository;
import com.online.cupcakes.cupcakes.repository.VendasSumarioRepository;

@Service
public class VendasSumarioService {
	
	@Autowired
	private VendasSumarioRepository vendasSumarioRepository;
	
	private final String TIPO_RELATORIO = "VENDAS_SUMARIZADO";
	
	public VendasSumario getVendasSumario(){
		
		Optional<VendasSumario> vendasSumarioSearch = vendasSumarioRepository.getByNomeRelatorio(TIPO_RELATORIO);
		
		if(vendasSumarioSearch.isEmpty()) {
			VendasSumario vendasSumarioNew = new VendasSumario();
			vendasSumarioNew.setNomeRelatorio(TIPO_RELATORIO);
			vendasSumarioNew.setTotalClientes(0);
			vendasSumarioNew.setTotalItensVendido(0);
			vendasSumarioNew.setTotalVendas(0);
			vendasSumarioNew.setTotalValor(0.0);
			vendasSumarioNew.setTotalItensEstoque(0);
			vendasSumarioRepository.save(vendasSumarioNew);
			
			return vendasSumarioNew;
		}else {
			return vendasSumarioSearch.get();
		}
	}
	
	public void updateVendasSumario(VendasSumario vendasSumario) {
		vendasSumarioRepository.save(vendasSumario);
	}
	
}
