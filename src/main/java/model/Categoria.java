package model;

public class Categoria {
    private int idCategoria;
    private String nomeCategoria;
    private TamanhoProduto tamanhoProduto;
    private TipoEmbalagem tipoEmbalagem;
    
    public Categoria() {
        
    }

    public Categoria(String nomeCategoria, TamanhoProduto tamanhoProduto, TipoEmbalagem tipoEmbalagem) {
        this.nomeCategoria = nomeCategoria;
        this.tamanhoProduto = tamanhoProduto;
        this.tipoEmbalagem = tipoEmbalagem;
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNome(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
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
