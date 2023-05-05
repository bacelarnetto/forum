CREATE TABLE role(
    id INT NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO role (id, nome) VALUES  (1, 'LEITURA_ESCRITA');
INSERT INTO role (id, nome) VALUES  (2, 'ADMIN');
