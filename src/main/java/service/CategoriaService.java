package service;

import java.util.List;

import dao.CategoriaDAO;
import exception.DadosInvalidosException;
import model.Categoria;
import model.TamanhoProduto;
import model.TipoEmbalagem;

public class CategoriaService {
    
    private final CategoriaDAO categoriaDAO;

    public CategoriaService() {
        categoriaDAO = new CategoriaDAO();
    }

    public void salvarCategoria(String nome, TamanhoProduto tamanho, TipoEmbalagem tipoEmbalagem) {
        if (nome == null) {
            throw new DadosInvalidosException("A categoria deve ter um nome.");
        }

        if (tamanho == null) {
            throw new DadosInvalidosException("A categoria deve ter um tamanho.");
        }

        if (tipoEmbalagem == null) {
            throw new DadosInvalidosException("A categoria deve ter um tipo de embalagem.");
        }

        List<Categoria> categoriasExistentes = categoriaDAO.listarTodos();
        for (Categoria c : categoriasExistentes) {
            if (c.getNomeCategoria() == nome && c.getTamanhoProduto() == tamanho && c.getTipoEmbalagem() == tipoEmbalagem) {
                throw new DadosInvalidosException("Categoria já existente.");
            }
        }

        Categoria novaCategoria = new Categoria(nome, tamanho, tipoEmbalagem);
        categoriaDAO.inserir(novaCategoria);
    }

    public void atualizarCategoria(int idCategoria, String novoNome, TamanhoProduto novoTamanho, TipoEmbalagem novoTipoEmbalagem) {
        if (idCategoria <= 0) {
            throw new DadosInvalidosException("Id tem que ser maior que 0.");
        }

        Categoria categoriaExistente = categoriaDAO.buscarPorId(idCategoria);
        if (categoriaExistente == null) {
            throw new DadosInvalidosException("Categoria não existe");
        }

        if (novoNome == null) {
            throw new DadosInvalidosException("O nome da categoria não pode ser vazio.");
        }
        if (novoTamanho == null) {
            throw new DadosInvalidosException("O tamanho da categoria deve ser especificado.");
        }
        if (novoTipoEmbalagem == null) {
            throw new DadosInvalidosException("O tipo de embalagem da categoria deve ser especificado.");
        }

        List<Categoria> categoriasExistentes = categoriaDAO.listarTodos();
        for (Categoria c : categoriasExistentes) {
            if (c.getNomeCategoria() == novoNome && c.getTamanhoProduto() == novoTamanho && c.getTipoEmbalagem() == novoTipoEmbalagem) {
                throw new DadosInvalidosException("Já existe essa categoria.");
            }
        }

        categoriaExistente.setNome(novoNome);
        categoriaExistente.setTamanhoProduto(novoTamanho);
        categoriaExistente.setTipoEmbalagem(novoTipoEmbalagem);

        categoriaDAO.atualizar(categoriaExistente);
    }

    public void deletarCategoria(int idCategoria) {
        if (idCategoria <= 0) {
            throw new DadosInvalidosException("Id deve ser maior que 0.");
        }

        Categoria categoria = categoriaDAO.buscarPorId(idCategoria);
        if (categoria == null) {
            throw new DadosInvalidosException("Categoria não encontrada.");
        }

        categoriaDAO.deletar(idCategoria);
    }

    public Categoria buscarCategoriaPorId(int id) {
        return categoriaDAO.buscarPorId(id);
    }

    public List<Categoria> listarTodasCategorias() {
        return categoriaDAO.listarTodos();
    }
    
}
