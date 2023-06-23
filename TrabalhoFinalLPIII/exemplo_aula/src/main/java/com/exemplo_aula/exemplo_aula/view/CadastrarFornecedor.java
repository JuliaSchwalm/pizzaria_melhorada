package com.exemplo_aula.exemplo_aula.view;

import java.util.Scanner;

import com.exemplo_aula.exemplo_aula.config.Sistema;
import com.exemplo_aula.exemplo_aula.model.Fornecedor;
import com.exemplo_aula.exemplo_aula.model.Ingrediente;

public class CadastrarFornecedor {
    //menu de cadastro do cliente
    public static void cadastrarFornecedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\033[0;37mInserindo um novo fornecedor:\033[0;34m ");

        System.out.print("\033[0;37mDigite o nome:\033[0;34m  ");
        String nome = scanner.nextLine();
        
        System.out.print("\033[0;37mDigite o CNPJ:\033[0;34m  ");
        String cnpj = scanner.next();
        scanner.nextLine();

        System.out.print("\033[0;37mDigite o nome do ingrediente que fornece:\033[0;34m  "); //ver o que fazer por conta da tabela 
        String ingrediente = scanner.next();
        scanner.nextLine();

        if(Sistema.fornecedorController.cadastrarFornecedor(nome, cnpj, ingrediente)) {
            System.out.println("\n\033[0;32mFornecedor cadastrado com sucesso!\n");
        }
        else {
            System.out.println("\n\033[0;31mCNPJ já cadastrado!\n");
        }
    }

    //menu para remover fornecedor
    public static void removerFornecedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\033[0;37mDigite o id do fornecedor:\033[0;34m ");
        Long idFornecedor = scanner.nextLong();
        if(Sistema.fornecedorController.removerFornecedor(idFornecedor)) {
            System.out.println("\n\033[0;32mFornecedor removido com sucesso!\n");
        }
        else {
            System.out.println("\n\033[0;31mId não encontrado!\n");
        }
    }


    //atualizar um fornecedor
    public static void atualizarFornecedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\033[0;37mDigite o id do fornecedor:\033[0;34m ");
        Long idFornecedor = scanner.nextLong();
        scanner.nextLine();

        Fornecedor fornecedor = Sistema.fornecedorController.obterFornecedor(idFornecedor);
        if(fornecedor == null) {
            System.out.println("\n\033[0;31mId não encontrado!\n");
            return;
        }

        System.out.println("\n\033[0;37mAtualizando fornecedor com id \033[0;32m"+fornecedor.getIdFornecedor()+"\033[0;37m:\033[0;34m ");

        System.out.print("\033[0;37mDigite o novo nome (\033[0;32m"+ fornecedor.getNome() +"\033[0;37m):\033[0;34m  ");
        String nome = scanner.nextLine();

        System.out.print("\033[0;37mDigite o novo ingrediente(\033[0;32m"+ fornecedor.getIngrediente() +"\033[0;37m):\033[0;34m  ");
        String ingrediente = scanner.nextLine();
        scanner.nextLine();

        if(Sistema.fornecedorController.atualizarFornecedor(idFornecedor,nome, fornecedor.getCnpj(), ingrediente)) {
            System.out.println("\n\033[0;32mFornecedor atualizado com sucesso!\n");
        }
        else {
            System.out.println("\n\033[0;31mCNPJ já cadastrado!\n");
        }
    }

    //listar todos os fornecedores
    public static void exibirTodosFornecedores() {
        System.out.println();
        for(Fornecedor fornecedor : Sistema.fornecedorController.obterTodosFornecedores()) {
             System.out.println(" \033[0;33m- Id: \033[0;37m" + fornecedor.getIdFornecedor() + 
             " \033[0;33m Nome: \033[0;37m" + fornecedor.getNome() +
             " \033[0;33m CNPJ: \033[0;37m" + fornecedor.getCnpj() +
             " \033[0;33m Ingrediente: \033[0;37m" + fornecedor.getIngrediente()
             );
        }
        System.out.println();
    }
}
