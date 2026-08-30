package com.hvsoftware.almox_sb.service;

import com.hvsoftware.almox_sb.dto.RequisicaoDTO;
import com.hvsoftware.almox_sb.repository.RequisicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class RequisicaoService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    public List<RequisicaoDTO> listarRequisicoes(){
        return requisicaoRepository.findAll().stream()
                .map(requisicao -> new RequisicaoDTO(
                        requisicao.getId(),
                        requisicao.getItens(),
                        requisicao.getDataHora(),
                        requisicao.getSetorRequisitante(),
                        requisicao.getResponsavelRequisitante()))
                .collect(Collectors.toList());
    }

}
