package com.online.cupcakes.cupcakes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.cupcakes.cupcakes.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	public Optional<Pedido> getByIdTransacao(String idTransacao);
	
}
