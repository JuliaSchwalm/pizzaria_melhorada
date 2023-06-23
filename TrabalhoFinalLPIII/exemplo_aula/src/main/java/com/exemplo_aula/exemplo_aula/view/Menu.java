package com.exemplo_aula.exemplo_aula.view;

import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public void menuInicial() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\033[0;33m### Menu Principal ###");
            System.out.println("\033[0;37m 1 - Cadastrar cliente");
            System.out.println("\033[0;37m 2 - Exibir clientes");
            System.out.println("\033[0;37m 3 - Atualizar cliente");
            System.out.println("\033[0;37m 4 - Remover cliente");
            System.out.println("\033[0;37m 5 - LIDAR COM FORNECEDOR");
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
                        CadastroCliente.cadastrarCliente();
                        break;
                    case 2:
                        CadastroCliente.exibirTodosClientes();
                        break;
                    case 3:
                        CadastroCliente.atualizarCliente();
                        break;
                    case 4:
                        CadastroCliente.removerCliente();
                        break;
                    case 5:
                        MenuFornecedor menuFornecedor = new MenuFornecedor();
                        menuFornecedor.menuInicial();
                        break;
                    case 0:
                      System.exit(0);
                        break;
                }


            
        }
    }

}
