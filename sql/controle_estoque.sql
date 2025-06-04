CREATE DATABASE controle_estoque;

USE controle_estoque;

CREATE TABLE tb_categoria (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tamanho_produto ENUM('Pequeno', 'Médio', 'Grande'),
    tipo_embalagem ENUM('Lata', 'Vidro', 'Plástico'),
    PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE tb_produto (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    unidade_medida ENUM('Unidade', 'Quilograma', 'Litro', 'Caixa') NOT NULL,
    id_categoria INT NOT NULL,
    quantidade_estoque INT NOT NULL,
    quantidade_minima INT NOT NULL,
    quantidade_maxima INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES tb_categoria(id)
) ENGINE = InnoDB;

