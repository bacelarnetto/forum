CREATE TABLE curso(
    id INT NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    categoria varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO curso(nome, categoria) VALUES ('Kotlin', 'PROGRAMACAO');
