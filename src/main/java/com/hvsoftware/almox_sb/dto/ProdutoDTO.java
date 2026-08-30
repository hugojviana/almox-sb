package com.hvsoftware.almox_sb.dto;

import com.hvsoftware.almox_sb.model.Categoria;

public record ProdutoDTO(Long id,
                         String nome,
                         Double quantidade,
                         String unidadeDeMedida,
                         Double quantidadeMinima,
                         Double preco,
                         Categoria categoria){
}
