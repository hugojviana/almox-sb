package com.hvsoftware.almox_sb.repository;

import com.hvsoftware.almox_sb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Override
    Optional<Produto> findById(Long Id);
}

