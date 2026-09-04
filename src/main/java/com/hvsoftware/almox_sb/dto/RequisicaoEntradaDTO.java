package com.hvsoftware.almox_sb.dto;

import java.util.List;

public record RequisicaoEntradaDTO(String setorRequisitante,
                                  String responsavelRequisitante,
                                  List<ItemRequisicaoEntradaDTO> itens) {
}
