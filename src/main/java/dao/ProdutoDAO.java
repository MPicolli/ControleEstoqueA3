package dao;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {

    List<Produto> produtos = new ArrayList<>();

    public boolean adicionarProduto(Produto produto) {
        produtos.add(produto);
        return true;
    }
    
}
