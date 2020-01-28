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
    @Column(name = "id_produto")
    private Long idProduto;
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;
    @Column(name = "qtd_movimentacao")
    private Long qtdMovimentacao;

    public Movimentacao(Long id, Long idProduto, Long idCliente, TipoMovimentacao tipoMovimentacao, Long qtdMovimentacao ) {
        this.id = id;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
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

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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
