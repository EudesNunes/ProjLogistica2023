package br.edu.univille.projlogistica2023.Enums;

public enum EnumStatus {
    TRANSITOPARACD("Em trânsito para o CD"),
    SEPARACAO("Em separação"),
    TRANSITODESTINO("Em trânsito para o destino"),
    RETIDO("Retido");

   
    private final String descricao;

    EnumStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
