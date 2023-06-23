package com.exemplo_aula.exemplo_aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo_aula.exemplo_aula.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    Cliente findByCpf(String cpf);
}
