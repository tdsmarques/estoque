package com.infnet.Estoque.service;

import com.infnet.Estoque.model.Movimentacao;
import com.infnet.Estoque.model.Produto;
import com.infnet.Estoque.repository.IMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoDeMovimentacao  {

    @Autowired
    private IMovimentacaoRepository repositorio;

    public ResponseEntity buscarPorID(Long id){
        return repositorio.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Movimentacao> listarTodos(){
        return repositorio.findAll();
    }

    public Movimentacao salvar(Movimentacao movimentacao){
        return repositorio.save(movimentacao);
    }

    public ResponseEntity atualizarMovimentacao(Movimentacao movimentacao, Long id){
        return repositorio.findById(id)
                .map(entidade -> {
                    entidade.setNomeCliente(movimentacao.getNomeCliente());
                    entidade.setNomeProduto(movimentacao.getNomeProduto());
                    entidade.setQtdMovimentacao(movimentacao.getQtdMovimentacao());
                    entidade.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
                    Movimentacao updated = repositorio.save(entidade);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity deletarMovimentacao(Long id){
        return repositorio.findById(id)
                .map(record -> {
                    repositorio.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
