package com.infnet.Estoque.service;

import com.infnet.Estoque.model.Cliente;
import com.infnet.Estoque.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeCliente {

    @Autowired
    private IClienteRepository repositorio;

    public ResponseEntity buscarPorID(Long id){
        return repositorio.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Cliente> listarTodos(){
        return repositorio.findAll();
    }

    public Cliente salvar(Cliente cliente){
        return repositorio.save(cliente);
    }

    public ResponseEntity atualizarCliente(Cliente cliente, Long id){
        return repositorio.findById(id)
                .map(entidade -> {
                    entidade.setNome(cliente.getNome());
                    entidade.setNrDocumento(cliente.getNrDocumento());
                    entidade.setTipoPessoa(cliente.getTipoPessoa());
                    Cliente updated = repositorio.save(entidade);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deletarCliente(Long id){
        return repositorio.findById(id)
                .map(record -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
