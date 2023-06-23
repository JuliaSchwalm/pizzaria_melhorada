package com.exemplo_aula.exemplo_aula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exemplo_aula.exemplo_aula.model.Cliente;
import com.exemplo_aula.exemplo_aula.repository.ClienteRepository;



@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public boolean cadastrarCliente(String nome, String cpf, String email) {

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);

        if(clienteRepository.findByCpf(cpf) == null) {
            clienteRepository.save(cliente);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean atualizarCliente(Long id, String nome, String cpf, String email) {

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);

        clienteRepository.save(cliente);
        return true;
    }

    public List<Cliente> obterTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obterCliente(Long id) {
        if(clienteRepository.existsById(id)) {
            return clienteRepository.findById(id).get();
        }
        else {
            return null;
        }
        
    }

    public boolean removerCliente(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
