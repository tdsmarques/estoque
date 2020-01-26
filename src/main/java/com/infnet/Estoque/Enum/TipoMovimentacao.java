package com.infnet.Estoque.Enum;

public enum TipoMovimentacao {
    ENTRADA(1),
    SAIDA(2);

    public int valor;
    TipoMovimentacao(int valor) {
        this.valor = valor;
    }
}
