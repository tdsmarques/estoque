package com.infnet.Estoque.controller;

import com.infnet.Estoque.service.ServicoDeRelatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/relatorio"})
public class RelatorioController {

    @Autowired
    ServicoDeRelatorio servicoDeRelatorio;
}
