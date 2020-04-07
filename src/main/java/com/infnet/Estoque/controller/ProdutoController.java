package com.infnet.Estoque.controller;

import com.infnet.Estoque.model.Produto;
import com.infnet.Estoque.service.ServicoDeProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping({"/produto"})
public class ProdutoController {

    @Autowired
    ServicoDeProduto servico;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Produto> listar(){
        return servico.listarTodos();
    }


    @CrossOrigin(origins = "*")
    @GetMapping(path = {"/{id}"})
    public ResponseEntity buscarPorID(@PathVariable Long id){
        return servico.buscarPorID(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public Produto produto(@RequestBody Produto produto){
        return servico.salvar(produto);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(value="/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody Produto produto) {
        return servico.atualizarProduto(produto, id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity deletar(@PathVariable long id){
        return  servico.deletarProduto(id);
    }

}
