package service;

import java.util.List;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        produtoDAO = new ProdutoDAO();
    }

}

    public boolean cadastrarProduto(Produto produto) {
        if (produto != null && produto.getNome() != null && produto.getNome().isEmpty()) {
            // return produtoDAO.inserir(produto);                              PRECISA COLOCAR INSERIR ATUALIZAR NO PRODUTODAO
        }
    }

public boolean atualizarProduto(Produto produto) {
    if (produto != null && produto.getId() > 0) {
//        return produtoDAO.atualizar(produto);                                   PRECISA COLOCAR INSERIR ATUALIZAR NO PRODUTODAO
    }
    return false;
}
