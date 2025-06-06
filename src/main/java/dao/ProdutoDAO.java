package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.DatabaseException;
import model.Categoria;
import model.Produto;
import model.UnidadeMedida;

public class ProdutoDAO {
    private static final String TB_PRODUTO = "tb_produto";
    private static final String ID_PRODUTO = "id_produto";
    private static final String NOME = "nome";
    private static final String PRECO = "preco";
    private static final String UNIDADE_MEDIDA = "unidade_medida";
    private static final String ID_CATEGORIA = "id_categoria";
    private static final String QTD_ESTOQUE = "quantidade_estoque";
    private static final String QTD_MINIMA = "quantidade_minima";
    private static final String QTD_MAXIMA = "quantidade_maxima";

    public ProdutoDAO() {
    }

    public void inserir(Produto produto) {
        String sql = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?)",
                TB_PRODUTO, NOME, PRECO, UNIDADE_MEDIDA, ID_CATEGORIA,
                QTD_ESTOQUE, QTD_MINIMA, QTD_MAXIMA);

        try (Connection conexao = ConnectionFactory.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPreco());

            if (produto.getUnidadeMedida() == null) {
                throw new DatabaseException(
                        "A unidade de medida do produto não pode ser nula, pois é um campo obrigatório.");
            }

            stmt.setString(3, produto.getUnidadeMedida().toString());

            if (produto.getCategoria() == null || produto.getCategoria().getIdCategoria() <= 0) {
                throw new DatabaseException("A categoria do produto é inválida ou não foi definida.");
            }

            stmt.setInt(4, produto.getCategoria().getIdCategoria());
            stmt.setInt(5, produto.getQuantidadeEstoque());
            stmt.setInt(6, produto.getQuantidadeMinima());
            stmt.setInt(7, produto.getQuantidadeMaxima());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir produto: " + e.getMessage(), e);
        }
    }

    public void atualizar(Produto produto) {
        String sql = String.format(
                "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
                TB_PRODUTO, NOME, PRECO, UNIDADE_MEDIDA, ID_CATEGORIA,
                QTD_ESTOQUE, QTD_MINIMA, QTD_MAXIMA, ID_PRODUTO);

        try (Connection conexao = ConnectionFactory.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getPreco());

            if (produto.getUnidadeMedida() == null) {
                throw new DatabaseException(
                        "A unidade de medida do produto não pode ser nula, pois é um campo obrigatório.");
            }
            stmt.setString(3, produto.getUnidadeMedida().toString());

            if (produto.getCategoria() == null || produto.getCategoria().getIdCategoria() <= 0) {
                throw new DatabaseException("A categoria do produto é inválida ou não foi definida.");
            }
            stmt.setInt(4, produto.getCategoria().getIdCategoria());

            stmt.setInt(5, produto.getQuantidadeEstoque());
            stmt.setInt(6, produto.getQuantidadeMinima());
            stmt.setInt(7, produto.getQuantidadeMaxima());
            stmt.setInt(8, produto.getIdProduto());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    public void deletar(int idProduto) {
        String sql = String.format("DELETE FROM %s WHERE %s = ?", TB_PRODUTO, ID_PRODUTO);

        try (Connection conexao = ConnectionFactory.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }

    public Produto buscarPorId(int idProduto) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", TB_PRODUTO, ID_PRODUTO);
        Produto produtoEncontrado = null;

        try (Connection conexao = ConnectionFactory.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produtoEncontrado = mapearProduto(rs);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao buscar produto por ID: " + e.getMessage(), e);
        }
        return produtoEncontrado;
    }

    public List<Produto> listarTodos() {
        List<Produto> listaProdutos = new ArrayList<>();
        String sql = String.format("SELECT * FROM %s", TB_PRODUTO);

        try (Connection conexao = ConnectionFactory.getConnection();
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                listaProdutos.add(mapearProduto(rs));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao listar todos os produtos: " + e.getMessage(), e);
        }
        return listaProdutos;
    }

    private Produto mapearProduto(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setIdProduto(rs.getInt(ID_PRODUTO));
        p.setNomeProduto(rs.getString(NOME));
        p.setPreco(rs.getDouble(PRECO));

        String unidadeMedidaDescricaoBD = rs.getString(UNIDADE_MEDIDA);
        if (unidadeMedidaDescricaoBD != null && !unidadeMedidaDescricaoBD.trim().isEmpty()) {
            try {
                p.setUnidadeMedida(UnidadeMedida.fromString(unidadeMedidaDescricaoBD));
            } catch (IllegalArgumentException e) {
                System.err.printf("AVISO: Unidade de medida '%s' (Produto ID: %d) não reconhecida. " +
                        "Erro: %s. Verifique a consistência dos dados e o enum UnidadeMedida.%n",
                        unidadeMedidaDescricaoBD, rs.getInt(ID_PRODUTO), e.getMessage());
                throw new SQLException("Falha ao mapear unidade de medida inválida do banco: '"
                        + unidadeMedidaDescricaoBD + "' para o Produto ID: " + rs.getInt(ID_PRODUTO), e);
            }
        } else {
            throw new SQLException(
                    "Unidade de medida retornou nula ou vazia do banco para um campo NOT NULL. Produto ID: "
                            + rs.getInt(ID_PRODUTO));
        }

        p.setQuantidadeEstoque(rs.getInt(QTD_ESTOQUE));
        p.setQuantidadeMinima(rs.getInt(QTD_MINIMA));
        p.setQuantidadeMaxima(rs.getInt(QTD_MAXIMA));

        Categoria c = new Categoria();
        c.setIdCategoria(rs.getInt(ID_CATEGORIA));
        p.setCategoria(c);

        return p;
    }
}
