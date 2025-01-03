package com.bielsoft.desafioForumHubONE.dtos.topicoDtos;


import com.bielsoft.desafioForumHubONE.entities.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(
        @NotBlank(message = "O titulo é obrigatório e nao pode ser nullo ou vazio")
        String titulo,
        @NotBlank(message = "O mensagem é obrigatório e nao pode ser nullo ou vazio")
        String mensagem,
        @NotBlank
        Long usuarioId,
        @NotBlank
        Long cursoId) {

    public TopicoDTO(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getUsuario().getId(),
                topico.getCurso().getId()
        );
    }
}
