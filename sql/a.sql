CREATE DATABASE a;

USE a;

CREATE TABLE tb_produto (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL (10, 2) NOT NULL,
    unidade_medida ENUM('Unidade', 'Quilograma', 'Litro', 'Caixa') NOT NULL,
    id_categoria INT NOT NULL,
    data CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
    CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES tb_categoria(id)
) ENGINE = InnoDB;

