package br.com.global_solutions.domain.enums;

public enum StatusEvento {
    ATIVO("Ativo"),
    ENCERRADO("Encerrado"),
    EM_OBSERVACAO("Em Observação");

    private final String descricao;

    StatusEvento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
