package com.exemplo_aula.exemplo_aula.view;

import java.util.Scanner;

import com.exemplo_aula.exemplo_aula.config.Sistema;
import com.exemplo_aula.exemplo_aula.model.Cliente;



public class CadastroCliente {
    

    public static void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\033[0;37mInserindo um novo cliente:\033[0;34m ");

        System.out.print("\033[0;37mDigite o nome:\033[0;34m  ");
        String nome = scanner.nextLine();
        
        System.out.print("\033[0;37mDigite o CPF:\033[0;34m  ");
        String cpf = scanner.next();
        scanner.nextLine();

        System.out.print("\033[0;37mDigite o e-mail:\033[0;34m  ");
        String email = scanner.next();
        scanner.nextLine();

        if(Sistema.clienteController.cadastrarCliente(nome, cpf, email)) {
            System.out.println("\n\033[0;32mUsuário cadastrado com sucesso!\n");
        }
        else {
            System.out.println("\n\033[0;31mCPF já cadastrado!\n");
        }
    }

    public static void removerCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\033[0;37mDigite o id do cliente:\033[0;34m ");
        Long id = scanner.nextLong();
        if(Sistema.clienteController.removerCliente(id)) {
            System.out.println("\n\033[0;32mCliente removido com sucesso!\n");
        }
        else {
            System.out.println("\n\033[0;31mId não encontrado!\n");
        }
    }

    public static void atualizarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\033[0;37mDigite o id do cliente:\033[0;34m ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        Cliente cliente = Sistema.clienteController.obterCliente(id);
        if(cliente == null) {
            System.out.println("\n\033[0;31mId não encontrado!\n");
            return;
        }

        System.out.println("\n\033[0;37mAtualizando cliente com id \033[0;32m"+cliente.getId()+"\033[0;37m:\033[0;34m ");

        System.out.print("\033[0;37mDigite o novo nome (\033[0;32m"+ cliente.getNome() +"\033[0;37m):\033[0;34m  ");
        String nome = scanner.nextLine();

        System.out.print("\033[0;37mDigite o novo e-mail(\033[0;32m"+ cliente.getEmail() +"\033[0;37m):\033[0;34m  ");
        String email = scanner.next();
        scanner.nextLine();

        if(Sistema.clienteController.atualizarCliente(id,nome, cliente.getCpf(), email)) {
            System.out.println("\n\033[0;32mUsuário atualizado com sucesso!\n");
        }
        else {
            System.out.println("\n\033[0;31mCPF já cadastrado!\n");
        }
    }


    public static void exibirTodosClientes() {
        System.out.println();
        for(Cliente cliente : Sistema.clienteController.obterTodosClientes()) {
             System.out.println(" \033[0;33m- Id: \033[0;37m" + cliente.getId() + 
             " \033[0;33m Nome: \033[0;37m" + cliente.getNome() +
             " \033[0;33m CPF: \033[0;37m" + cliente.getCpf() +
             " \033[0;33m E-mail: \033[0;37m" + cliente.getEmail()
             );
        }
        System.out.println();
    }
}
