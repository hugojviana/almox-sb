package com.hvsoftware.almox_sb.service;

import com.hvsoftware.almox_sb.dto.ItemRequisicaoDTO;
import com.hvsoftware.almox_sb.dto.RequisicaoDTO;
import com.hvsoftware.almox_sb.repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

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

}
