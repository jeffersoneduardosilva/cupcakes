package com.online.cupcakes.cupcakes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.cupcakes.cupcakes.entity.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
	
	public Optional<Cliente> getByCpf(String cpf);

}
