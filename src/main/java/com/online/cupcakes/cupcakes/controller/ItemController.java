package com.online.cupcakes.cupcakes.controller;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
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
import com.online.cupcakes.cupcakes.repository.ItemRepository;

@RestController
@RequestMapping("/controller/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> all() {
    	List<Item> findAll = itemRepository.findAll();
    	return ResponseEntity.ok(findAll);
    }
	
	@CrossOrigin(origins = "*")
	@GetMapping("/itens/{id}")
	ResponseEntity<Optional<Item>> one(@PathVariable Long id) {
		Optional<Item> item = itemRepository.findById(id);
		return ResponseEntity.ok(item);
	}
    
	@CrossOrigin(origins = "*")
	@PostMapping
	ResponseEntity<?> newItem(@RequestBody Item item) {
		Item itemSalvo = itemRepository.save(item);
		return ResponseEntity.created(URI.create("/controller/item")).body(itemSalvo);
	}
	
}
