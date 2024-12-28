package com.bielsoft.desafioForumHubONE.dtos.topicoDtos;

import com.bielsoft.desafioForumHubONE.entities.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoAtualizarDTO(
        @NotNull(message = "O id é obrigatório e nao pode ser nullo ou vazio")
        Long id,
        @NotBlank(message = "O titulo é obrigatório e nao pode ser nullo ou vazio")
        String titulo,
        @NotBlank(message = "O mensagem é obrigatório e nao pode ser nullo ou vazio")
        String mensagem,
        @NotNull(message = "O id do usuario é obrigatório e nao pode ser nulo")
        Long usuarioId,
        @NotNull(message = "O id do curso é obrigatório e nao pode ser nulo")
        Long cursoId
) {

    public TopicoAtualizarDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getUsuario().getId(),
                topico.getCurso().getId()
        );
    }
}
