package com.infnet.Estoque.service;

import com.infnet.Estoque.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeProduto {
    private IProdutoRepository repositorio;

    public ServicoDeProduto(IProdutoRepository produtoRepository) {
        this.repositorio = produtoRepository;
    }
}
