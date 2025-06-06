package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exception.DatabaseException;
import model.Categoria;
import model.TamanhoProduto;
import model.TipoEmbalagem;

public class CategoriaDAO {

    private static final String TB_CATEGORIA = "tb_categoria";
    private static final String ID = "id_categoria";
    private static final String NOME = "nome";
    private static final String TAMANHO = "tamanho_produto";
    private static final String EMBALAGEM = "tipo_embalagem";

    public void inserir(Categoria categoria) {
        String sql = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)",
                TB_CATEGORIA, NOME, TAMANHO, EMBALAGEM);

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getTamanhoProduto().toString());
            stmt.setString(3, categoria.getTipoEmbalagem().toString());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir categoria: " + e.getMessage(), e);
        }
    }

    public void atualizar(Categoria categoria) {
        String sql = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?",
                TB_CATEGORIA, NOME, TAMANHO, EMBALAGEM, ID);

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getTamanhoProduto().toString());
            stmt.setString(3, categoria.getTipoEmbalagem().toString());
            stmt.setInt(4, categoria.getIdCategoria());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao atualizar categoria: " + e.getMessage(), e);
        }
    }

    public void deletar(int id) {
        String sql = String.format("DELETE FROM %s WHERE %s = ?", TB_CATEGORIA, ID);

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao deletar categoria: " + e.getMessage(), e);
        }
    }

    public Categoria buscarPorId(int id) {
        String sql = String.format("SELECT * FROM %s WHERE %s = ?", TB_CATEGORIA, ID);

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearCategoria(rs);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao buscar categoria por ID: " + e.getMessage(), e);
        }

        return null;
    }

    public List<Categoria> listarTodos() {
        String sql = String.format("SELECT * FROM %s", TB_CATEGORIA);
        List<Categoria> categorias = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                categorias.add(mapearCategoria(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Erro ao listar categorias: " + e.getMessage(), e);
        }

        return categorias;
    }

    private Categoria mapearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setIdCategoria(rs.getInt(ID));
        c.setNome(rs.getString(NOME));

        String tamanhoStr = rs.getString(TAMANHO);
        for (TamanhoProduto t : TamanhoProduto.values()) {
            if (t.toString().equalsIgnoreCase(tamanhoStr)) {
                c.setTamanhoProduto(t);
                break;
            }
        }

        String embalagemStr = rs.getString(EMBALAGEM);
        for (TipoEmbalagem e : TipoEmbalagem.values()) {
            if (e.toString().equalsIgnoreCase(embalagemStr)) {
                c.setTipoEmbalagem(e);
                break;
            }
        }

        return c;
    }
}
