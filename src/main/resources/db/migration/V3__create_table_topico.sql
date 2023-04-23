CREATE TABLE topico(
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(300) NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    curso_id INT NOT NULL,
    autor_id INT NOT NULL,
    PRIMARY KEY (id),
    foreign key (curso_id) references curso(id),
    foreign key (autor_id) references usuario(id)
);
