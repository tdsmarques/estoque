package com.infnet.Estoque.controller;

import com.infnet.Estoque.model.Cliente;
import com.infnet.Estoque.service.ServicoDeCliente;
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
@RequestMapping({"/cliente"})
public class ClienteController {

    @Autowired
    ServicoDeCliente servico;

    @GetMapping
    public List<Cliente> listar(){
        return servico.listarTodos();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity buscarPorID(@PathVariable Long id){
        return servico.buscarPorID(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return servico.salvar(cliente);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        return servico.atualizarCliente(cliente, id);
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity deletar(@PathVariable long id){
        return  servico.deletarCliente(id);
    }
}
