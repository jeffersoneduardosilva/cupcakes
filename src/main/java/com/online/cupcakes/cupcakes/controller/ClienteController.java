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

import com.online.cupcakes.cupcakes.entity.Cliente;
import com.online.cupcakes.cupcakes.repository.ClienteRepository;

@RestController
@RequestMapping("/controller/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
    @Autowired
    public ClienteController() {
    }

    @CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> all() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
    @CrossOrigin(origins = "*")
    @GetMapping("/clientes/{id}")
    ResponseEntity<Optional<Cliente>> one(@PathVariable Long id) {
      return ResponseEntity.ok(clienteRepository.findById(id));
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping
    ResponseEntity<?> newEmployee(@RequestBody Cliente cliente) {
      Cliente clienteSalvo = clienteRepository.save(cliente);
      return ResponseEntity 
          .created(URI.create("/controller/cliente"))
          .body(clienteSalvo);
    }
    
}