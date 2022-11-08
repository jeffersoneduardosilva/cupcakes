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

import com.online.cupcakes.cupcakes.entity.Item;
import com.online.cupcakes.cupcakes.service.ItemService;

@RestController
@RequestMapping("/controller/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> allAtivos() {
    	List<Item> findAll = itemService.all();
    	return ResponseEntity.ok(findAll);
    }
	
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, path = "/cadastrados")
    public ResponseEntity<List<Item>> allCadastrados() {
    	List<Item> findAll = itemService.allCadastrados();
    	return ResponseEntity.ok(findAll);
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/itens/{id}")
	ResponseEntity<Optional<Item>> one(@PathVariable Long id) {
		Optional<Item> item = itemService.one(id);
		return ResponseEntity.ok(item);
	}
    
	@CrossOrigin(origins = "*")
	@PostMapping
	ResponseEntity<?> newItem(@RequestBody Item item) {
		Item itemSalvo = itemService.newItem(item);
		return ResponseEntity.created(URI.create("/controller/item")).body(itemSalvo);
	}
	
}
