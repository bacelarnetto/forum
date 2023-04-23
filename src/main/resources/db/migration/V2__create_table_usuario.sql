CREATE TABLE usuario(
    id INT NOT NULL AUTO_INCREMENT,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO usuario(nome, email) VALUES ('admin', 'admin@admin.com');
