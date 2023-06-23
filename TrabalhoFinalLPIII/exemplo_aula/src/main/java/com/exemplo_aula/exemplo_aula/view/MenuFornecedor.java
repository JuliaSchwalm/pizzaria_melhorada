package com.exemplo_aula.exemplo_aula.view;

import java.util.Scanner;

public class MenuFornecedor {

    public MenuFornecedor() {

    }

    public void menuInicial() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\033[0;33m### Menu Principal ###");
            System.out.println("\033[0;37m 1 - Cadastrar fornecedor");
            System.out.println("\033[0;37m 2 - Exibir fornecedores");
            System.out.println("\033[0;37m 3 - Atualizar fornecedor");
            System.out.println("\033[0;37m 4 - Remover fornecedor");
            System.out.println("\033[0;37m 5 - LIDAR COM CLIENTES");
            System.out.println("\033[0;37m 0 - Sair do programa");
            System.out.print("\033[0;37mEscolha uma das opções: \033[0;34m ");

            int opcao = -1;
            do {
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                } else {
                    scanner.nextLine();
                }
            } while (opcao < 0);

            switch (opcao) {
                case 1:
                    CadastrarFornecedor.cadastrarFornecedor();
                    break;
                case 2:
                    CadastrarFornecedor.exibirTodosFornecedores();
                    break;
                case 3:
                    CadastrarFornecedor.atualizarFornecedor();
                    break;
                case 4:
                    CadastrarFornecedor.removerFornecedor();
                    break;
                case 5:
                Menu menu = new Menu();
                menu.menuInicial();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

}
