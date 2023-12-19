create database vamos_viajar;

CREATE TABLE cliente(
    telefone varchar(15) NOT NULL,
    data_nascimento varchar(15) NOT NULL,
    email varchar(80) NOT NULL UNIQUE,
    cpf varchar(15) UNIQUE NOT NULL,
    id_cliente int PRIMARY KEY AUTO_INCREMENT,
    nome varchar(50)  NOT NULL,
    endereco varchar(80)  NOT NULL,
    senha varchar(20) NOT NULL
)DEFAULT charset = utf8mb4;

CREATE TABLE passagem (
    assento varchar(8)  NOT NULL,
    num_voo int UNIQUE  NOT NULL,
    data_hora varchar(25)  NOT NULL,
    valor float  NOT NULL,
    id_passagem int PRIMARY KEY AUTO_INCREMENT,
    fk_cliente_id_cliente int  NOT NULL,
    fk_id_destino int NOT NULL
)DEFAULT charset = utf8mb4;

CREATE TABLE destino (
    id_destino int PRIMARY KEY AUTO_INCREMENT,
    cidade varchar(20) NOT NULL,
    estado varchar(20) NOT NULL,
    pais varchar(20) NOT NULL,
    aeroporto varchar(40) NOT NULL,
    promocao float
)DEFAULT charset = utf8mb4;

ALTER TABLE passagem
ADD CONSTRAINT fk_cliente_id_cliente
FOREIGN KEY (fk_cliente_id_cliente)
REFERENCES cliente (id_cliente)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
    
ALTER TABLE passagem ADD CONSTRAINT fk_id_destino
FOREIGN KEY (fk_id_destino)
REFERENCES destino (id_destino)
ON DELETE CASCADE;