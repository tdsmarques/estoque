CREATE TABLE mysqldb.movimentacao (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idProduto int,
    idCliente int,
    tipoMovimentacao int,
    qtdMovimentacao int,
    FOREIGN KEY (idProduto) REFERENCES produto(id),
    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);