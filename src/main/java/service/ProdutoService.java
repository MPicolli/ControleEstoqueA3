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
//        return produtoDAO.inserir(produto);                                     PRECISA COLOCAR INSERIR  NO PRODUTODAO
        }
    }

    public boolean atualizarProduto(Produto produto) {
    if (produto != null && produto.getId() > 0) {
//        return produtoDAO.atualizar(produto);                                   PRECISA COLOCAR ATUALIZAR NO PRODUTODAO
    }
    return false;
}

    public boolean excluirProduto(int id){
        if (id > 0) {
//            return produtoDAO.excluir(id);                                   PRECISA COLOCAR EXCLUIR NO PRODUTODAO
        }
            return false;
    }
    public List<Produto> listarProdutos(){
//        return produtoDAO.buscarTodosProdutos;                                 PRECISA COLOCAR BUSCARTODOSPRODUTOS NO PRODUTODAO
    }

    public Produto buscarPorId(int id) {
//        return produtoDAO.buscarPorId(id);                                 PRECISA COLOCAR BUSCARPORID NO PRODUTODAO
    }