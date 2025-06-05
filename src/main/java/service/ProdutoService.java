package service;

import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {

    private final ProdutoDAO produtoDAO;

    public ProdutoService() {
        produtoDAO = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) {
        if (produto != null && produto.getNomeProduto() != null && !produto.getNomeProduto().isEmpty()) {
            produtoDAO.inserir(produto);
        } else {
            throw new IllegalArgumentException("Produto inválido para cadastro.");
        }
    }

    public void atualizarProduto(Produto produto) {
        if (produto != null && produto.getIdProduto() > 0) {
            produtoDAO.atualizar(produto);
        } else {
            throw new IllegalArgumentException("Produto inválido para atualização.");
        }
    }

    public void excluirProduto(int id) {
        if (id > 0) {
            produtoDAO.deletar(id);
        } else {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarTodos();
    }

    public Produto buscarPorId(int id) {
        if (id > 0) {
            return produtoDAO.buscarPorId(id);
        }
        return null;
    }

    public void reajustarPreco(double percentual) {
        if (percentual == 0) return;
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

    public void movimentarEstoque(int idProduto, int quantidade, boolean entrada) {
        Produto produto = buscarPorId(idProduto);
        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado para movimentação.");
        }

        int novaQuantidade = entrada
                ? produto.getQuantidadeEstoque() + quantidade
                : produto.getQuantidadeEstoque() - quantidade;

        produto.setQuantidadeEstoque(novaQuantidade);
        atualizarProduto(produto);
    }
}
