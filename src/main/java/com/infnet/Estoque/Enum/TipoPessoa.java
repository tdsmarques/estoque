package com.infnet.Estoque.Enum;

public enum TipoPessoa {
    PESSOA_FISICA(1),
    PESSOA_JURIDICA(2);

    public int valor;

    TipoPessoa(int valor) {
        this.valor = valor;
    }
}
