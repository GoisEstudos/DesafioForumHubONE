package com.bielsoft.desafioForumHubONE.dtos;

import com.bielsoft.desafioForumHubONE.entities.Perfil;
import com.bielsoft.desafioForumHubONE.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UsuarioDTO(
        @NotBlank(message = "O id é obrigatório e nao pode ser nullo ou vazio")
        Long id,
        @NotBlank(message = "O nome é obrigatório e nao pode ser nullo ou vazio")
        String nome,
        @NotBlank(message = "O email é obrigatório e nao pode ser nullo ou vazio")
        String email
){

    public UsuarioDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
