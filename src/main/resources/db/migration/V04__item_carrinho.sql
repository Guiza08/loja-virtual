CREATE TABLE item_carrinho (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	codigo_produto BIGINT NOT NULL,
	codigo_carrinho BIGINT NOT NULL,
	quantidade INTEGER NOT NULL,
	preco DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
	FOREIGN KEY (codigo_carrinho) REFERENCES carrinho(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO item_carrinho(codigo_produto, codigo_carrinho, quantidade, preco) values (1, 1, 1, 870);
INSERT INTO item_carrinho(codigo_produto, codigo_carrinho, quantidade, preco) values (2, 1, 1, 249);
INSERT INTO item_carrinho(codigo_produto, codigo_carrinho, quantidade, preco) values (2, 2, 1, 1623.20);
INSERT INTO item_carrinho(codigo_produto, codigo_carrinho, quantidade, preco) values (1, 3, 1, 1073.36);