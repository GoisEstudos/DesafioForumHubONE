package com.bielsoft.desafioForumHubONE.dtos;

import jakarta.validation.constraints.NotBlank;

public record PerfilDTO(
        @NotBlank(message = "O id é obrigatório e nao pode ser nullo ou vazio")
        Long id,
        @NotBlank(message = "O nome é obrigatório e nao pode ser nullo ou vazio")
        String nome) {
}
