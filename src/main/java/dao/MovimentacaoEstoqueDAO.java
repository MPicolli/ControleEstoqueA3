package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exception.DatabaseException;
import model.MovimentacaoEstoque;
import model.Produto;

public class MovimentacaoEstoqueDAO {

    private final Connection conexao;

    public MovimentacaoEstoqueDAO() {
        this.conexao = Conexao.getConnection();
    }

    public void inserir(MovimentacaoEstoque mov) {
        String sql = "INSERT INTO tb_movimentacao_estoque (id_produto, tipo_movimentacao, data_movimentacao, observacoes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, mov.getProduto().getIdProduto());
            stmt.setString(2, mov.getTipoMovimentacao().toString());
            stmt.setDate(3, java.sql.Date.valueOf(mov.getDataMovimentacao()));
            stmt.setString(4, mov.getObservacoes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir movimentação: " + e.getMessage());
        }
    }

    public List<MovimentacaoEstoque> listarTodos() {
        List<MovimentacaoEstoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_movimentacao_estoque";
        try (Statement stmt = conexao.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MovimentacaoEstoque mov = new MovimentacaoEstoque();
                mov.setIdMovimentacao(rs.getInt("id_movimentacao"));

                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                mov.setProduto(p);

                mov.setTipoMovimentacao(rs.getString("tipo_movimentacao"));
                mov.setDataMovimentacao(rs.getDate("data_movimentacao").toLocalDate());
                mov.setObservacoes(rs.getString("observacoes"));

                lista.add(mov);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao listar movimentações: " + e.getMessage());
        }
        return lista;
    }
}
