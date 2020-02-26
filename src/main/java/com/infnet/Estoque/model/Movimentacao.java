package com.infnet.Estoque.model;

import com.infnet.Estoque.Enum.TipoMovimentacao;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nm_produto")
    private String nomeProduto;
    @Column(name = "nm_cliente")
    private String nomeCliente;
    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;
    @Column(name = "qtd_movimentacao")
    private Long qtdMovimentacao;

    public Movimentacao(Long id, String nomeProduto, String nomeCliente, TipoMovimentacao tipoMovimentacao, Long qtdMovimentacao ) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.nomeCliente = nomeCliente;
        this.tipoMovimentacao = tipoMovimentacao;
        this.qtdMovimentacao = qtdMovimentacao;
    }

    public Movimentacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Long getQtdMovimentacao() {
        return qtdMovimentacao;
    }

    public void setQtdMovimentacao(Long qtdMovimentacao) {
        this.qtdMovimentacao = qtdMovimentacao;
    }
}
