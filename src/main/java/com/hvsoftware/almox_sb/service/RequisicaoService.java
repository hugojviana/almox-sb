package com.hvsoftware.almox_sb.service;

import com.hvsoftware.almox_sb.dto.ItemRequisicaoDTO;
import com.hvsoftware.almox_sb.dto.ItemRequisicaoEntradaDTO;
import com.hvsoftware.almox_sb.dto.RequisicaoDTO;
import com.hvsoftware.almox_sb.dto.RequisicaoEntradaDTO;
import com.hvsoftware.almox_sb.model.ItemRequisicao;
import com.hvsoftware.almox_sb.model.Produto;
import com.hvsoftware.almox_sb.model.Requisicao;
import com.hvsoftware.almox_sb.repository.ProdutoRepository;
import com.hvsoftware.almox_sb.repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<RequisicaoDTO> listarRequisicoes(){
        return requisicaoRepository.findAll().stream()
                .map(requisicao -> new RequisicaoDTO(
                        requisicao.getId(),
                        requisicao.getItens().stream()
                                .map(item -> new ItemRequisicaoDTO(
                                        item.getProduto().getNome(),
                                        item.getQuantidade(),
                                        item.getProduto().getUnidadeDeMedida()))
                                .collect(Collectors.toList()),
                        requisicao.getDataHora(),
                        requisicao.getSetorRequisitante(),
                        requisicao.getResponsavelRequisitante()))
                .collect(Collectors.toList());
    }

    public void requisitar(RequisicaoEntradaDTO requisicaoEntradaDTO) {

        List<ItemRequisicao> itemListaRequisicao = new ArrayList<>();
        Requisicao requisicao = new Requisicao();
        requisicao.setDataHora(LocalDateTime.now());
        requisicao.setSetorRequisitante(requisicaoEntradaDTO.setorRequisitante());
        requisicao.setResponsavelRequisitante(requisicaoEntradaDTO.responsavelRequisitante());

        for (ItemRequisicaoEntradaDTO item : requisicaoEntradaDTO.itens()) {
            var produtoOptional = produtoRepository.findById(item.produtoId());
            if(produtoOptional.isEmpty()){
                throw new IllegalArgumentException("Um ou mais produtos nao foram encontrados");
            }
            var produtoEncontrado = produtoOptional.get();
            if(item.quantidade() > produtoEncontrado.getQuantidade()){
                throw new IllegalArgumentException("Estoque Indisponível");
            }
        }
        for(ItemRequisicaoEntradaDTO item : requisicaoEntradaDTO.itens()){
            var produtoOptional = produtoRepository.findById(item.produtoId());
            var produtoEncontrado = produtoOptional.get();
            var novaQuantidade = produtoEncontrado.getQuantidade()-item.quantidade();

            produtoEncontrado.setQuantidade(novaQuantidade);
            produtoRepository.save(produtoEncontrado);

            ItemRequisicao itemRequisicao = new ItemRequisicao();
            itemRequisicao.setRequisicao(requisicao);
            itemRequisicao.setProduto(produtoEncontrado);
            itemRequisicao.setQuantidade(item.quantidade());
            itemListaRequisicao.add(itemRequisicao);

        }
            requisicao.setItens(itemListaRequisicao);
            requisicaoRepository.save(requisicao);
    }
}
