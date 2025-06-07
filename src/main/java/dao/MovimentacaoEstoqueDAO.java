package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DatabaseException;
import model.MovimentacaoEstoque;
import model.Produto;
import model.TipoMovimentacao;

public class MovimentacaoEstoqueDAO {

    @SuppressWarnings("FieldMayBeFinal")
    private Connection conexao;

    public MovimentacaoEstoqueDAO() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void inserir(MovimentacaoEstoque mov) {
        String sql = "INSERT INTO tb_movimentacao_estoque (id_produto, tipo_movimentacao, data_movimentacao, observacoes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, mov.getProduto().getIdProduto());
            stmt.setString(2, mov.getTipoMovimentacao().toString());
            stmt.setDate(3, java.sql.Date.valueOf(mov.getDataMovimentacao()));
            stmt.setString(4, mov.getObservacoes());
            stmt.setInt(5, mov.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir movimentação: " + e.getMessage());
        }
    }

    public List<MovimentacaoEstoque> listarTodos() {
        List<MovimentacaoEstoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_movimentacao_estoque";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MovimentacaoEstoque mov = new MovimentacaoEstoque();
                Produto p = new Produto();
                p.setIdProduto(rs.getInt("id_produto"));
                mov.setProduto(p);

                String tipoMovimentacaoStr = rs.getString("tipo_movimentacao");
                if (tipoMovimentacaoStr != null) {
                    mov.setTipoMovimentacao(TipoMovimentacao.valueOf(tipoMovimentacaoStr.toUpperCase()));
                }

                mov.setDataMovimentacao(rs.getDate("data_movimentacao").toLocalDate());
                mov.setObservacoes(rs.getString("observacoes"));
                mov.setQuantidade(rs.getInt("quantidade"));
                lista.add(mov);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao listar movimentações: " + e.getMessage());
        }
        return lista;
    }

}