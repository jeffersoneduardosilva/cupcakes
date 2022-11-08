package com.online.cupcakes.cupcakes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.cupcakes.cupcakes.entity.Item;
import com.online.cupcakes.cupcakes.entity.VendasSumario;
import com.online.cupcakes.cupcakes.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private VendasSumarioService vendasSumarioService; 
	
	public List<Item> all() {
    	return itemRepository.findAllComEstoque();
    }
	
	public List<Item> allCadastrados() {
    	return itemRepository.findAll();
    }
	
	public Optional<Item> one(Long id) {
		return itemRepository.findById(id);
	}
	
	public Item newItem(Item item) {
		Item save = itemRepository.save(item);
		
		VendasSumario vendasSumario = vendasSumarioService.getVendasSumario();
		vendasSumario.setTotalItensEstoque(vendasSumario.getTotalItensEstoque() + item.getQuantidadeEstoque().intValue());
		
		vendasSumarioService.updateVendasSumario(vendasSumario);
		
		return save;
	}
	
}
