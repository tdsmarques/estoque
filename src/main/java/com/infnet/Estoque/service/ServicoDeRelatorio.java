package com.infnet.Estoque.service;

import com.infnet.Estoque.repository.IClienteRepository;
import com.infnet.Estoque.repository.IMovimentacaoRepository;
import com.infnet.Estoque.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoDeRelatorio {

    private IClienteRepository repositorioDeCliente;
    private IMovimentacaoRepository repositorioDeMovimentacao;
    private IProdutoRepository repositorioDeProduto;

    public ServicoDeRelatorio(IClienteRepository repositorioDeCliente, IMovimentacaoRepository repositorioDeMovimentacao, IProdutoRepository repositorioDeProduto) {
        this.repositorioDeCliente = repositorioDeCliente;
        this.repositorioDeMovimentacao = repositorioDeMovimentacao;
        this.repositorioDeProduto = repositorioDeProduto;
    }
}
