package com.bielsoft.desafioForumHubONE.dtos;

import com.bielsoft.desafioForumHubONE.entities.Curso;
import jakarta.validation.constraints.NotBlank;

public record CursoDTO(
        @NotBlank(message = "O id é obrigatório e nao pode ser nullo ou vazio")
        Long id,
        @NotBlank(message = "O nome é obrigatório e nao pode ser nullo ou vazio")
        String nome,
        @NotBlank(message = "O categoria é obrigatório e nao pode ser nullo ou vazio")
        String categoria) {
    public CursoDTO(Curso curso) {
        this(
                curso.getId(),
                curso.getNome(),
                curso.getCategoria()
        );
    }
}
