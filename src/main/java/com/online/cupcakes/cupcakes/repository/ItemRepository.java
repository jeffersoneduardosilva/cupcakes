package com.online.cupcakes.cupcakes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.online.cupcakes.cupcakes.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i where i.quantidadeEstoque > 0")
	List<Item> findAllComEstoque();
	
}
