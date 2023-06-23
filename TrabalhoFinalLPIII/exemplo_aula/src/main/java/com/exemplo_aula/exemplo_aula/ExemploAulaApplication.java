package com.exemplo_aula.exemplo_aula;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exemplo_aula.exemplo_aula.config.Sistema;
import com.exemplo_aula.exemplo_aula.view.Menu;
import com.exemplo_aula.exemplo_aula.view.MenuFornecedor;

@SpringBootApplication
public class ExemploAulaApplication {

	public static void main(String[] args) {
		new Sistema(args);
		int num;

		do {
			Scanner ler = new Scanner(System.in);
			System.out.println("Você deseja mexer com cliente ou fornecedor?");
			System.out.println("Digite 1 para cliente, 2 para fornecedor e 0 para sair.");
			num = ler.nextInt();

			switch (num) {
				case 1:
					Menu menu = new Menu();
					menu.menuInicial();
					break;
				case 2:
					MenuFornecedor menuFornecedor = new MenuFornecedor();
					menuFornecedor.menuInicial();
					break;
				case 0:
					System.out.println("Finalizado com sucesso!");
					break;
				default:
					System.out.println("Número não identificado!");
			}
		} while (num != 0);
	}

}
