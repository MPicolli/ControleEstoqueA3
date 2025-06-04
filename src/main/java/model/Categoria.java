package model;

public class Categoria {
    
    private int id;
    private String nome;
    private TamanhoProduto tamanhoProduto;
    private TipoEmbalagem tipoEmbalagem;

    public Categoria(String nome, TamanhoProduto tamanhoProduto, TipoEmbalagem tipoEmbalagem) {
        this.nome = nome;
        this.tamanhoProduto = tamanhoProduto;
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TamanhoProduto getTamanhoProduto() {
        return tamanhoProduto;
    }

    public void setTamanhoProduto(TamanhoProduto tamanhoProduto) {
        this.tamanhoProduto = tamanhoProduto;
    }

    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

}
