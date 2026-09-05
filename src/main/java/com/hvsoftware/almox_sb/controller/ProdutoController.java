package com.hvsoftware.almox_sb.controller;


import com.hvsoftware.almox_sb.dto.ProdutoDTO;
import com.hvsoftware.almox_sb.dto.ProdutoEntradaDTO;
import com.hvsoftware.almox_sb.dto.RequisicaoDTO;
import com.hvsoftware.almox_sb.dto.RequisicaoEntradaDTO;
import com.hvsoftware.almox_sb.service.ProdutoService;
import com.hvsoftware.almox_sb.service.RequisicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/requisicoes/salvar")
    public ResponseEntity<Void> fazerRequisicao(@RequestBody RequisicaoEntradaDTO requisicaoEntradaDTO){
        requisicaoService.requisitar(requisicaoEntradaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/produtos/salvar")
    public ResponseEntity<Void> salvarProdutos(@RequestBody ProdutoEntradaDTO produtoEntradaDTO){
        produtoService.salvar(produtoEntradaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
