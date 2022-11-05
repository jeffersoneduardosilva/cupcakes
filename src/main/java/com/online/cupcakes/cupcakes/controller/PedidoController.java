package com.online.cupcakes.cupcakes.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.cupcakes.cupcakes.controller.request.PedidoRequest;
import com.online.cupcakes.cupcakes.entity.Pedido;
import com.online.cupcakes.cupcakes.repository.PedidoRepository;
import com.online.cupcakes.cupcakes.service.PedidoService;

@RestController
@RequestMapping("/controller/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> all() {
		return ResponseEntity.ok(pedidoRepository.findAll());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/pedidos/{id}")
	ResponseEntity<Optional<Pedido>> one(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return ResponseEntity.ok(pedido);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping
	ResponseEntity<?> newPedido(@RequestBody PedidoRequest pedidoRequest) {
		Pedido pedidoSalvo = pedidoService.newPedido(pedidoRequest);
		return ResponseEntity.created(URI.create("/controller/pedido")).body(pedidoSalvo);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/pedidos/id-transacao/{idTransacao}")
	ResponseEntity<Optional<Pedido>> getByIdTransacao(@PathVariable String idTransacao) {
		Optional<Pedido> pedido = pedidoRepository.getByIdTransacao(idTransacao);
		return ResponseEntity.ok(pedido);
	}
	
}
