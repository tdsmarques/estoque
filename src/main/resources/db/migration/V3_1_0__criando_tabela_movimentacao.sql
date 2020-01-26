CREATE TABLE mysqldb.movimentacao (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idProduto int,
    idCliente int,
    tipoMovimentacao int,
    qtdMovimentacao int,
    FOREIGN KEY (idProduto) REFERENCES mysqldb.produto(id),
    FOREIGN KEY (idCliente) REFERENCES mysqldb.cliente(id)
);