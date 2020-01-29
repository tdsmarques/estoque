package com.infnet.Estoque.controller;

import com.infnet.Estoque.model.Movimentacao;
import com.infnet.Estoque.model.Produto;
import com.infnet.Estoque.service.ServicoDeMovimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/movimentacao"})
public class MovimentacaoController {

    @Autowired
    ServicoDeMovimentacao servico;

    @GetMapping
    public List<Movimentacao> listar(){
        return servico.listarTodos();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity buscarPorID(@PathVariable Long id){
        return servico.buscarPorID(id);
    }

    @PostMapping
    public Movimentacao movimentacao(@RequestBody Movimentacao movimentacao){
        return servico.salvar(movimentacao);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody Movimentacao movimentacao) {
        return servico.atualizarMovimentacao(movimentacao, id);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity deletar(@PathVariable long id){
        return  servico.deletarMovimentacao(id);
    }
}
