package com.infnet.Estoque.repository;

import com.infnet.Estoque.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimentacaoRepository extends JpaRepository <Movimentacao, Long> {
}
