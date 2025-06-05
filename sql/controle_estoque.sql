CREATE DATABASE controle_estoque;

USE controle_estoque;

CREATE TABLE tb_categoria (
    id_categoria INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tamanho_produto ENUM('Pequeno', 'Médio', 'Grande'),
    tipo_embalagem ENUM('Lata', 'Vidro', 'Plástico'),
    PRIMARY KEY (id_categoria)
) ENGINE = InnoDB;

CREATE TABLE tb_produto (
    id_produto INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    unidade_medida ENUM('Unidade', 'Quilograma', 'Litro', 'Caixa') NOT NULL,
    id_categoria INT NOT NULL,
    quantidade_estoque INT NOT NULL,
    quantidade_minima INT NOT NULL,
    quantidade_maxima INT NOT NULL,
    PRIMARY KEY (id_produto),
    CONSTRAINT fk_id_categoria FOREIGN KEY (id_categoria) REFERENCES tb_categoria(id_categoria)
) ENGINE = InnoDB;

CREATE TABLE tb_movimentacao_estoque (
    id_movimentacao INT NOT NULL AUTO_INCREMENT,
    tipo_movimentacao ENUM('ENTRADA', 'SAIDA') NOT NULL,
    data_movimentacao DATE NOT NULL,
    observacoes VARCHAR(250),
    id_produto INT NOT NULL,
    PRIMARY KEY (id_movimentacao),
    CONSTRAINT fk_id_produto FOREIGN KEY (id_produto) REFERENCES tb_produto(id_produto)
) ENGINE = InnoDB;