CREATE TABLE IF NOT EXISTS dadosusuario (
	`id` INT NOT NULL AUTO_INCREMENT,
    `usuario` VARCHAR(60) NULL,
    `senha` VARCHAR(45) NULL,
    PRIMARY KEY(`id`));
    
    SELECT * FROM dadosusuario;
    
    INSERT INTO dadosusuario (usuario, senha) VALUES ("Joaquina", "j12a");
    
    UPDATE bdusuario.dadosusuario SET senha = "296506902c693b458707ad6f7e24a544" where usuario = "Silvio";