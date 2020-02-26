CREATE TABLE mysqldb.movimentacao (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nm_produto varchar(50),
    nm_cliente varchar(50),
    tipo_movimentacao int,
    qtd_movimentacao int
);