CREATE TABLE carrinho (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	data DATE NOT NULL,
	codigo_cliente BIGINT NOT NULL,
	FOREIGN KEY (codigo_cliente) REFERENCES cliente(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO carrinho(data, codigo_cliente) values ('2021-01-02', 1);
INSERT INTO carrinho(data, codigo_cliente) values ('2021-01-08', 2);
INSERT INTO carrinho(data, codigo_cliente) values ('2021-01-25', 2);
INSERT INTO carrinho(data, codigo_cliente) values ('2021-01-12', 3);