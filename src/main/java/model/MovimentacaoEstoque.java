package model;

public class MovimentacaoEstoque {

    private int idMovimentacao;
    private TipoMovimentacao tipoMovimentacao;
    private java.time.LocalDate dataMovimentacao;
    private String observacoes;
    private Produto produto;
    private int quantidade;

    public MovimentacaoEstoque() {

    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public java.time.LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(java.time.LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "MovimentacaoEstoque{" +
                "idMovimentacao=" + idMovimentacao +
                ", tipoMovimentacao=" + tipoMovimentacao +
                ", dataMovimentacao=" + dataMovimentacao +
                ", observacoes='" + observacoes + '\'' +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
