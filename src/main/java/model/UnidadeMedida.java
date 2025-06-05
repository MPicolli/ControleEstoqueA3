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

    public static UnidadeMedida fromString(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia. Valor fornecido: " + descricao);
        }
        String descricaoNormalizada = descricao.trim();
        for (UnidadeMedida unidadeMedida : values()) {
            if (unidadeMedida.getDescricao().equalsIgnoreCase(descricaoNormalizada)) {
                return unidadeMedida;
            }
        }
        throw new IllegalArgumentException(
                "Nenhuma unidade de medida corresponde à descrição: '" + descricaoNormalizada + "'");
    }
}
