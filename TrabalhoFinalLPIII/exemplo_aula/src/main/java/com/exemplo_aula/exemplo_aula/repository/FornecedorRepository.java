package com.exemplo_aula.exemplo_aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo_aula.exemplo_aula.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Long>{
    
    Fornecedor findByCnpj(String cnpj);
}
