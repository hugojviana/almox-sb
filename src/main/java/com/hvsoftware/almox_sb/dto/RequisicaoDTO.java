package com.hvsoftware.almox_sb.dto;

import com.hvsoftware.almox_sb.model.ItemRequisicao;

import java.time.LocalDateTime;
import java.util.List;

public record RequisicaoDTO(Long id,
                            List<ItemRequisicao> itens,
                            LocalDateTime dataHora,
                            String setorRequisitante,
                            String responsavelRequisitante){
}
