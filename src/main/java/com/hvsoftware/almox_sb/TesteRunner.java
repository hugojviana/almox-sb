//package com.hvsoftware.almox_sb;
//
//import com.hvsoftware.almox_sb.model.Produto;
//import com.hvsoftware.almox_sb.service.ProdutoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class TesteRunner implements CommandLineRunner {
//
//    @Autowired
//    private ProdutoService service;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Produto teste1 = new Produto();
//        teste1.setNome("teste10");
//        service.salvar(teste1);
//
//        List<Produto> todos = service.listarTodos();
//        todos.forEach(System.out::println);
//        System.out.println("Produtos no banco: " + todos);
//    }
//}