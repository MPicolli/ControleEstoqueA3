package service;

import java.util.List;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        produtoDAO = new ProdutoDAO();
    }

    public boolean cadastrarProduto(Produto produto) {
        if (produto != null && produto.getNome() != null && !produto.getNome().isEmpty()) {
        return produtoDAO.inserir(produto);
        }
        return false;
    }

    public boolean atualizarProduto(Produto produto) {
        if (produto != null && produto.getId() > 0) {
            return produtoDAO.atualizar(produto);
        }
        return false;
    }

    public boolean excluirProduto(int id) {
        if (id > 0) {
            return produtoDAO.excluir(id);
        }
        return false;
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.buscarTodosProdutos();
    }

    public Produto buscarPorId(int id) {
        return produtoDAO.buscarPorId(id);
    }

    public void reajustarPreco(double percentual) {
        List<Produto> produtos = listarProdutos();
        for (Produto produto : produtos) {
            double novoPreco = produto.getPreco() * (1 + percentual / 100);
            produto.setPreco(novoPreco);
            atualizarProduto(produto);
        }
    }

    public boolean estaAbaixoDoMinimo(Produto produto) {
        return produto.getQuantidadeEstoque() < produto.getQuantidadeMinima();
    }

    public boolean estaAcimaDoMaximo(Produto produto) {
        return produto.getQuantidadeEstoque() > produto.getQuantidadeMaxima();
    }

    public boolean movimentarEstoque(int idProduto, int quantidade, boolean entrada) {
        Produto produto = buscarPorId(idProduto);
        if (produto == null)
            return false;

        int novaQuantidade = entrada
                ? produto.getQuantidadeEstoque() + quantidade
                : produto.getQuantidadeEstoque() - quantidade;

        produto.setQuantidadeEstoque(novaQuantidade);
        return atualizarProduto(produto);
    }
}