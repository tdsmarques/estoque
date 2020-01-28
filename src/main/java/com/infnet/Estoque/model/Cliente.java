package com.infnet.Estoque.model;

import com.infnet.Estoque.Enum.TipoPessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "tipo_pessoa")
    private TipoPessoa tipoPessoa;
    @Column(name = "nr_documento")
    private String nrDocumento;

    public Cliente(Long id, String nome, TipoPessoa tipoPessoa, String nrDocumento) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoa = tipoPessoa;
        this.nrDocumento = nrDocumento;
    }

    public Cliente() {
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNrDocumento() {
        return nrDocumento;
    }

    public void setNrDocumento(String nrDocumento) {
        this.nrDocumento = nrDocumento;
    }
}
