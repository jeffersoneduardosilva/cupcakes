package com.online.cupcakes.cupcakes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.cupcakes.cupcakes.entity.VendasSumario;

public interface VendasSumarioRepository  extends JpaRepository<VendasSumario, Long>{
	
	public Optional<VendasSumario> getByNomeRelatorio(String nomeRelatorio);

}
