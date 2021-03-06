package com.infnet.Estoque.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String unidade;
    private Long quantidade;
    private boolean perecivel;

    public Produto(Long id, String nome, String unidade, Long quantidade, boolean perecivel) {
        this.id = id;
        this.nome = nome;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.perecivel = perecivel;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }
}
