# SistemaBancarioDevWeb
Trabalho da matéria de Introdução ao Desenvolvimento WEB para Sistemas de Informação no período de 2023.2
:)

Insira os comando SQLs abaixo para gerar o seu banco de dados

```SQL
DROP DATABASE IF EXISTS BootstrapJavaBank;
create database BootstrapJavaBank;
use BootstrapJavaBank;

DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS contas;
DROP TABLE IF EXISTS transacoes;

-- Tabela de Usuários

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Tabela de Contas
CREATE TABLE contas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idUsuario INT,
    tipo VARCHAR(20) NOT NULL,
    saldo DECIMAL(10, 2) DEFAULT 0,
    FOREIGN KEY (idUsuario) REFERENCES usuarios(id)

);

-- Tabela de Transações
CREATE TABLE transacoes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    idEmissor INT,
    idDestinatario INT,
    valor DECIMAL(10, 2) NOT NULL,
    dataTransacao DATETIME,
    FOREIGN KEY (idEmissor) REFERENCES contas(id),
    FOREIGN KEY (idDestinatario) REFERENCES contas(id)
);

INSERT INTO usuarios (nome, tipo, senha, cpf, email)
VALUES ('Rodrigo Nogueira', 'cliente', '123', '22222222222', 'rodnog@email.com');

INSERT INTO usuarios (nome, tipo, senha, cpf, email)
VALUES ('Thalys Pacheco', 'cliente', '123', '33333333333', 'thalys@email.com');

INSERT INTO usuarios (nome, tipo, senha, cpf, email)
VALUES ("Diego Admin","admin","123", "11111111111","diegoadmin@email.com");

INSERT INTO usuarios (id, nome, tipo, senha, cpf, email)
VALUES (-1, "Sistema","cliente","123", "00000000000","sistema@email.com");

INSERT INTO contas (id, idUsuario, tipo, saldo) VALUES(-1, -1, "Conta Corerente", 0.0);

INSERT INTO contas (idUsuario, tipo, saldo) VALUES(1, "Conta Corerente", 10);

INSERT INTO contas (idUsuario, tipo, saldo) VALUES(3, "Conta Corerente", 0);

INSERT INTO transacoes (idEmissor, idDestinatario, valor, dataTransacao) VALUES(-1, 1, 10, NOW());
```
