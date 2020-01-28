CREATE TABLE mysqldb.cliente (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50),
    tipo_pessoa int,
    nr_documento varchar(20)
);