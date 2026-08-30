package com.hvsoftware.almox_sb.controller;


import com.hvsoftware.almox_sb.dto.ProdutoDTO;
import com.hvsoftware.almox_sb.model.Produto;
import com.hvsoftware.almox_sb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/listar")
    public List<ProdutoDTO> listarTodos(){
        return service.listarTodos();
    }
}
