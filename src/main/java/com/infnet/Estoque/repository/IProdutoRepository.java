package com.infnet.Estoque.repository;

import com.infnet.Estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
