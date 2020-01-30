CREATE TABLE mysqldb.movimentacao (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_produto int,
    id_cliente int,
    tipo_movimentacao int,
    qtd_movimentacao int,
    FOREIGN KEY (id_produto) REFERENCES produto(id),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);