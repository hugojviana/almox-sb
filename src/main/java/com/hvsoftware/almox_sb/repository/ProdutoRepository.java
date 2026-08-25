package com.hvsoftware.almox_sb.repository;

import com.hvsoftware.almox_sb.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
