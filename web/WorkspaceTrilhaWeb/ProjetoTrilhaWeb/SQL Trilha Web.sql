CREATE DATABASE IF NOT EXISTS bdcoldigo DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS marcas (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT, 
    nome VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS produtos (
	id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, 
    categoria TINYINT(1) UNSIGNED NOT NULL,
    modelo VARCHAR(45) NOT NULL, 
    capacidade INT(4) UNSIGNED NOT NULL,
    valor DECIMAL(7,2) UNSIGNED NOT NULL,
    marcas_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    INDEX fk_produtos_marcas_idx (marcas_id ASC),
    CONSTRAINT fk_produtos_marcas
		FOREIGN KEY (marcas_id)
        REFERENCES marcas (id)
);

ALTER TABLE marcas ADD status TINYINT(1) NOT NULL DEFAULT 1;

SELECT * FROM bdcoldigo.produtos;
SELECT * FROM bdcoldigo.marcas;

SELECT * FROM marcas WHERE marcas.nome LIKE '%a%' ORDER BY marcas.nome DESC;

SELECT produtos.*, marcas.nome as marca FROM produtos INNER JOIN marcas ON produtos.marcas_id = marcas.id;

INSERT INTO marcas (nome) VALUES ("Consul");

SELECT * FROM produtos WHERE produtos.marcas_id = 9;

DELETE FROM bdcoldigo.marcas WHERE id = 9 AND produtos.marcas_id != 9;

SELECT * FROM marcas WHERE id = 8;

UPDATE marcas SET status = 0 WHERE id = 8;

DELETE FROM marcas WHERE id = 11

