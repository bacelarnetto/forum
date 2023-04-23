CREATE TABLE resposta(
    id INT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(300) NOT NULL,
    data_criacao DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    topico_id INT NOT NULL,
    autor_id INT NOT NULL,
    solucao INT NOT NULL,
    PRIMARY KEY (id),
    foreign key (topico_id) references topico(id),
    foreign key (autor_id) references usuario(id)
);
