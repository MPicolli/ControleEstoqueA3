package model;

public enum UnidadeMedida {
    UNIDADE("Unidade"),
    KG("Quilograma"),
    LITRO("Litro"),
    CAIXA("Caixa");

    private String descricao;

    private UnidadeMedida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
    
}
