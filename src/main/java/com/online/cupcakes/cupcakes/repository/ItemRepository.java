package com.online.cupcakes.cupcakes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.cupcakes.cupcakes.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
