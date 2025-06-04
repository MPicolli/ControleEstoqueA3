package model;

public enum TipoEmbalagem {
    LATA("Lata"),
    VIDRO("Vidro"),
    PLASTICO("Plástico");

    private String descricao;

    private TipoEmbalagem(String descricao) {
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
