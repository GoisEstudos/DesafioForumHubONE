package com.bielsoft.desafioForumHubONE.dtos.topicoDtos;

import com.bielsoft.desafioForumHubONE.dtos.CursoDTO;
import com.bielsoft.desafioForumHubONE.dtos.UsuarioDTO;
import com.bielsoft.desafioForumHubONE.entities.Topico;
import com.bielsoft.desafioForumHubONE.enums.StatusEnum;

import java.time.LocalDateTime;

public record TopicoPorIdDTO(
        String título,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusEnum status,
        UsuarioDTO usuario,
        CursoDTO curso
) {
    public TopicoPorIdDTO(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new UsuarioDTO(topico.getUsuario()),
                new CursoDTO(topico.getCurso())
        );
    }
}
