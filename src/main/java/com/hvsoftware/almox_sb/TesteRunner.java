package com.hvsoftware.almox_sb;

import com.hvsoftware.almox_sb.model.Produto;
import com.hvsoftware.almox_sb.repository.ProdutoRepository;
import com.hvsoftware.almox_sb.service.ProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ProdutoService service;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produto teste1 = new Produto();
        teste1.setNome("teste10");
        service.listarTodos();
        System.out.println("Produto salvo: " + teste1);
    }
}