CREATE TABLE mysqldb.produto (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome varchar(20),
    unidade varchar(50),
    quantidade int,
    perecivel boolean,
    data_vencimento varchar(50)
);