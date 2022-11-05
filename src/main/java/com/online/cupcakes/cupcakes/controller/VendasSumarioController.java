package com.online.cupcakes.cupcakes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.cupcakes.cupcakes.entity.VendasSumario;
import com.online.cupcakes.cupcakes.repository.VendasSumarioRepository;

@RestController
@RequestMapping("/controller/vendas/sumario")
public class VendasSumarioController {

	@Autowired
	private VendasSumarioRepository vendasSumarioRepository;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/{nomeRelatorio}")
	ResponseEntity<Optional<VendasSumario>> one(@PathVariable String nomeRelatorio) {
		Optional<VendasSumario> vendasSumario = vendasSumarioRepository.getByNomeRelatorio(nomeRelatorio);
		return ResponseEntity.ok(vendasSumario);
	}
    
	
}
