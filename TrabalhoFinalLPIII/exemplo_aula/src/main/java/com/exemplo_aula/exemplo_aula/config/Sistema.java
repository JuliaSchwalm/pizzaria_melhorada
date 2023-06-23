package com.exemplo_aula.exemplo_aula.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


import com.exemplo_aula.exemplo_aula.ExemploAulaApplication;
import com.exemplo_aula.exemplo_aula.controller.FornecedorController;
import com.exemplo_aula.exemplo_aula.controller.ClienteController;




public class Sistema {

    public static ClienteController clienteController;
    public static FornecedorController fornecedorController;
    
    public Sistema(String[] args) {
        System.out.println("\nInicializando o Spring, aguarde...");

        ConfigurableApplicationContext cactx = springBootApplicationContext(args);

        //inicializar todos controladores aqui
        clienteController = cactx.getBean(ClienteController.class);
        fornecedorController = cactx.getBean(FornecedorController.class);

        System.out.println("Spring inicializado!\n");
    }

    private ConfigurableApplicationContext springBootApplicationContext(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ExemploAulaApplication.class);
        return builder.run(args);
    }
}
