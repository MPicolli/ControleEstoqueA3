package service;

import java.time.LocalDate;
import java.util.List;

import dao.MovimentacaoEstoqueDAO;
import dao.ProdutoDAO;
import exception.DadosInvalidosException;
import exception.EstoqueInsuficienteException;
import exception.ProdutoNaoEncontradoException;
import exception.QuantidadeMinimaException;
import model.Categoria;
import model.MovimentacaoEstoque;
import model.Produto;
import model.TipoMovimentacao;

public class MovimentacaoEstoqueService {
    
    private final MovimentacaoEstoqueDAO movimentacaoEstoqueDAO;
    private final ProdutoDAO produtoDAO;
    
    public MovimentacaoEstoqueService() {
        movimentacaoEstoqueDAO = new MovimentacaoEstoqueDAO();
        produtoDAO = new ProdutoDAO();
    }

    public void registraEntrada(int idProduto, int quantidade, String observacao) throws DadosInvalidosException {
        if (quantidade <= 0) {
            throw new DadosInvalidosException("Quantidade deve ser maior que 0.");
        }

        Produto produto = produtoDAO.buscarPorId(idProduto);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");
        }

        if (produto.getQuantidadeEstoque() + quantidade > produto.getQuantidadeMaxima()) {
            throw new IllegalArgumentException("A quantidade total excederia o estoque máximo permitido.");
        }

        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setProduto(produto);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setDataMovimentacao(LocalDate.now());
        movimentacao.setObservacoes(observacao);

        movimentacaoEstoqueDAO.inserir(movimentacao);

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
        produtoDAO.atualizar(produto);
    }

    public void registrarSaida(int produtoId, int quantidade, String observacao) {
        if (quantidade <= 0) {
            throw new DadosInvalidosException("A quantidade não pode ser menor que 0");
        }

        Produto produto = produtoDAO.buscarPorId(produtoId);
        if (produto == null) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");
        }

        if (produto.getQuantidadeEstoque() < quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente");
        }

        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
        movimentacao.setProduto(produto);
        movimentacao.setQuantidade(quantidade);
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setDataMovimentacao(LocalDate.now());
        movimentacao.setObservacoes(observacao);

        movimentacaoEstoqueDAO.inserir(movimentacao);

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        produtoDAO.atualizar(produto);

        if (produto.getQuantidadeEstoque() < produto.getQuantidadeMinima()) {
            throw new QuantidadeMinimaException("O estoque do produto está abaixo da quantidade mínima.");
        }
    }

    public List<MovimentacaoEstoque> listarTodasMovimentacoes() {
        return movimentacaoEstoqueDAO.listarTodos();
    }

}
