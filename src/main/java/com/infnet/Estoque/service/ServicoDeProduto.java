package com.infnet.Estoque.service;

import com.infnet.Estoque.model.Cliente;
import com.infnet.Estoque.model.Produto;
import com.infnet.Estoque.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeProduto {

    @Autowired
    private IProdutoRepository repositorio;

    public ResponseEntity buscarPorID(Long id){
        return repositorio.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Produto> listarTodos(){
        return repositorio.findAll();
    }

    public Produto salvar(Produto produto){
        return repositorio.save(produto);
    }

    public ResponseEntity atualizarProduto(Produto produto, Long id){
        return repositorio.findById(id)
                .map(entidade -> {
                    entidade.setNome(produto.getNome());
                    entidade.setUnidade(produto.getUnidade());
                    entidade.setQuantidade(produto.getQuantidade());
                    entidade.setPerecivel(produto.isPerecivel());
                    entidade.setData_vencimento(produto.getData_vencimento());
                    Produto updated = repositorio.save(entidade);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deletarProduto(Long id){
        return repositorio.findById(id)
                .map(record -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
