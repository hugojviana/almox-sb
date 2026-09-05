package com.hvsoftware.almox_sb.service;

import com.hvsoftware.almox_sb.dto.ProdutoDTO;
import com.hvsoftware.almox_sb.dto.ProdutoEntradaDTO;
import com.hvsoftware.almox_sb.model.Produto;
import com.hvsoftware.almox_sb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDTO> listarTodos(){
        return repository.findAll()
                .stream().map(p-> new ProdutoDTO(p.getId(), p.getNome(), p.getQuantidade(), p.getUnidadeDeMedida(), p.getQuantidadeMinima(), p.getPreco(), p.getCategoria()))
                .collect(Collectors.toList());
    }

    public void salvar(ProdutoEntradaDTO produtoEntradaDTO){
        Produto produtoParaSalvar = new Produto();

        produtoParaSalvar.setNome(produtoEntradaDTO.nome());
        produtoParaSalvar.setQuantidade(produtoEntradaDTO.quantidade());
        produtoParaSalvar.setUnidadeDeMedida(produtoEntradaDTO.unidadeDeMedida());
        produtoParaSalvar.setQuantidadeMinima(produtoEntradaDTO.quantidadeMinima());
        produtoParaSalvar.setPreco(produtoEntradaDTO.preco());
        produtoParaSalvar.setCategoria(produtoEntradaDTO.categoria());

        repository.save(produtoParaSalvar);
    }

}
