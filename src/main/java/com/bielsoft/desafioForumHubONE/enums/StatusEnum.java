package com.bielsoft.desafioForumHubONE.enums;

public enum StatusEnum {

    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    private String descricao;

    private StatusEnum(String descricao) {
        this.descricao = descricao;
    }

}
