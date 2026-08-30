package com.hvsoftware.almox_sb.controller;


import com.hvsoftware.almox_sb.dto.ProdutoDTO;
import com.hvsoftware.almox_sb.dto.RequisicaoDTO;
import com.hvsoftware.almox_sb.service.ProdutoService;
import com.hvsoftware.almox_sb.service.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/listar")
    public List<ProdutoDTO> listarTodos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/requisicoes")
    public List<RequisicaoDTO> listarRequisicoes(){
        return requisicaoService.listarRequisicoes();
    }
}
