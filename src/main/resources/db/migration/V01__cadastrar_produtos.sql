CREATE TABLE produto (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(100) NOT NULL,
	quantidade INTEGER NOT NULL,
	preco DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(500)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO produto (descricao, quantidade, preco, observacao) values ('Celular Moto G7 Plus', 30, 1799.90, 'Celular Motorola Moto G7 Plus Indigo 64gb 4gb Ram Xt1965');
INSERT INTO produto (descricao, quantidade, preco, observacao) values ('Samsung Galaxy S9', 15, 2000.00, 'Smartphone Samsung Galaxy S9+ Tela 6.2 128gb 6gb De Ram');