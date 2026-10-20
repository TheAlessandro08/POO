use bdunivel;

DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS produtos;

CREATE TABLE usuarios (
	id INT AUTO_INCREMENT PRIMARY KEY,
	login VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(64) NOT NULL,
    tipo VARCHAR(1) CHECK (tipo IN('U','A')) DEFAULT 'U',
	ativo VARCHAR(1) CHECK (ativo IN ('T','F')) DEFAULT 'T',
    email VARCHAR(50),
	data_criacao DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE produtos (
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(50) NOT NULL,
preco FLOAT,
marca VARCHAR(50)
);

INSERT INTO usuarios VALUES (1,'alessandro','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','A','T','alessandro@gmail.com',current_date());
INSERT INTO usuarios VALUES
(2,'admale','123','A','T','alessandro@gmail.com',current_date());

INSERT INTO usuarios VALUES 
(3, 'kaua', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'U', 'T', 'kaua@gmail.com', current_date()),
(4, 'eduardo', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'U', 'T', 'eduardo@gmail.com', current_date()),
(5, 'joao', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'U', 'T', 'joao@gmail.com', current_date());

INSERT INTO produtos VALUES 
(1, 'Arroz Branco Tipo 1 5kg', 25.90, 'Camil'),
(2, 'Feijão Carioca 1kg', 8.50, 'Kicaldo'),
(3, 'Óleo de Soja 900ml', 6.20, 'Liza'),
(4, 'Leite UHT Integral 1L', 4.80, 'Parmalat'),
(5, 'Café Torrado e Moído 500g', 18.90, 'Pilão');
