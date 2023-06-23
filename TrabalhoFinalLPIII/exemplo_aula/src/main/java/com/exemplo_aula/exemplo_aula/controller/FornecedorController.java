package com.exemplo_aula.exemplo_aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exemplo_aula.exemplo_aula.model.Fornecedor;
import com.exemplo_aula.exemplo_aula.model.Ingrediente;
import com.exemplo_aula.exemplo_aula.repository.FornecedorRepository;

@Controller
public class FornecedorController {
    //referencia o bd
    @Autowired
    private FornecedorRepository fornecedorRepository;

    //cadastra os fornecedores no bd
    public boolean cadastrarFornecedor(String nome, String cnpj, String ingrediente) {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedor.setCnpj(cnpj);
        fornecedor.setIngrediente(ingrediente);

        if (fornecedorRepository.findByCnpj(cnpj) == null) {
            fornecedorRepository.save(fornecedor);
            return true;
        } else {
            return false;
        }
    }

    //atualiza os forncedores no bd
    public boolean atualizarFornecedor(Long idFornecedor, String nome, String cnpj, String ingrediente) {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor(idFornecedor);
        fornecedor.setNome(nome);
        fornecedor.setCnpj(cnpj);
        fornecedor.setIngrediente(ingrediente);

        fornecedorRepository.save(fornecedor);
        return true;
    }

    //lista os fornecedores 
    public List<Fornecedor> obterTodosFornecedores() {
        return fornecedorRepository.findAll();
    }

    //encontrar um fornecedor pelo id
    public Fornecedor obterFornecedor(Long idFornecedor) {
        if(fornecedorRepository.existsById(idFornecedor)) {
            return fornecedorRepository.findById(idFornecedor).get();
        }
        else {
            return null;
        }
        
    }

    //remover um fornecedor do bd pelo id
    public boolean removerFornecedor(Long idFornecedor) {
        if(fornecedorRepository.existsById(idFornecedor)) {
            fornecedorRepository.deleteById(idFornecedor);
            return true;
        }
        else {
            return false;
        }
    }
}