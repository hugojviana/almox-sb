package com.hvsoftware.almox_sb.service;

import com.hvsoftware.almox_sb.dto.ProdutoDTO;
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

    public void salvar(Produto produto){
        repository.save(produto);
    }

}
