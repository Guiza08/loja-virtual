CREATE TABLE cliente (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(20) NOT NULL,
	ativo BOOLEAN NOT NULL,
	logradouro VARCHAR(30),
	numero INTEGER,
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO cliente (nome, telefone, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('João Silva', '(34) 99261-4270', true, 'Rua do Abacaxi', 10, null, 'Brasil', '38.400-122', 'Uberlândia', 'MG');
INSERT INTO cliente (nome, telefone, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Maria Rita', '(34) 99261-4270', true, 'Rua do Sabiá', 110, 'Apto 101', 'Colina', '11.400-122', 'Ribeirão Preto', 'SP');
INSERT INTO cliente (nome, telefone, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Pedro Santos', '(34) 99261-4270', true, 'Rua da Bateria', 23, null, 'Morumbi', '54.212-122', 'Goiânia', 'GO');
INSERT INTO cliente (nome, telefone, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Ricardo Pereira', '(34) 99261-4270', true, 'Rua do Motorista', 123, 'Apto 302', 'Aparecida', '38.400-122', 'Salvador', 'BA');