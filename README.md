# Sistema de Controle de Estoque - UNISUL

## 📌 Descrição

Este projeto foi desenvolvido como parte da avaliação A3 da unidade curricular **Programação de Soluções Computacionais**, da **Universidade do Sul de Santa Catarina - UNISUL**.  
O objetivo é implementar um sistema de controle de estoque com base em um software modelo, utilizando linguagem Java, interface Swing e banco de dados MySQL.

O sistema permite o gerenciamento de produtos, categorias, movimentações de entrada e saída e emissão de relatórios úteis para o controle eficiente do estoque.

---

## 👥 Integrantes do Grupo

- **Gabriel Machado de Oliveira**
- **Luan Silveira de Almeida**
- **Matheus Picolli Ishibashi**
- **Jonathan Wesley Roesner Schiestl**
- **Pedro de Sousa Cuneo**
- **Arthur Gazzola van de Zand**

---

## 🔧 Tecnologias Utilizadas

- Java
- Swing
- JDBC
- MySQL
- Git e GitHub
- IDE: VSCode / NetBeans

---

## 📂 Funcionalidades

- Cadastro, consulta, atualização e exclusão de **Produtos**
- Cadastro, consulta, atualização e exclusão de **Categorias**
- **Movimentações** de entrada e saída de produtos
- Reajuste de preços por percentual
- **Relatórios**:
  - Lista de preços por ordem alfabética
  - Balanço físico-financeiro do estoque
  - Produtos abaixo da quantidade mínima
  - Produtos acima da quantidade máxima
  - Quantidade de produtos por categoria

---

## 🛠️ Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/MPicolli/ControleEstoqueA3.git
   ```
2. Configure o banco de dados MySQL usando o script fornecido em `/sql/controle_estoque.sql`
3. Configure o arquivo de conexão com o banco de dados (`ConnectionFactory.java`)
4. Compile e execute o projeto em sua IDE preferida

---

## 📊 Script do Banco de Dados

O script SQL completo para criação do banco de dados está localizado na pasta:
```
/sql/controle_estoque.sql
```

---

## 🎥 Apresentação em Vídeo

🔗 Link do vídeo: [inserir_link_do_video_youtube_aqui]

---

## 📁 Organização do Projeto

As funcionalidades foram distribuídas entre os membros do grupo. A descrição completa da contribuição individual está disponível no documento do trabalho (PDF).

---

## 📘 Licença

Este projeto é acadêmico e não possui fins comerciais.
