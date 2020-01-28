package com.infnet.Estoque.service;

import com.infnet.Estoque.repository.IMovimentacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeMovimentacao  {

    private IMovimentacaoRepository repositorioDeMovimentacao;

    public ServicoDeMovimentacao(IMovimentacaoRepository repositorioDeMovimentacao) {
        this.repositorioDeMovimentacao = repositorioDeMovimentacao;
    }
}
