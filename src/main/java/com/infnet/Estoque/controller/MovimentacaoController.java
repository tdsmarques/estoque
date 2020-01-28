package com.infnet.Estoque.controller;

import com.infnet.Estoque.service.ServicoDeMovimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/movimentacao"})
public class MovimentacaoController {

    @Autowired
    ServicoDeMovimentacao servicoDeMovimentacao;
}
