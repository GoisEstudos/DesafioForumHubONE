package com.bielsoft.desafioForumHubONE.dtos.usuarioDtos;

import com.bielsoft.desafioForumHubONE.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCriarDTO(
        @NotBlank(message = "O nome é obrigatório e nao pode ser nullo ou vazio")
        String nome,
        @NotBlank(message = "O email é obrigatório e nao pode ser nullo ou vazio")
        String email,
        @NotBlank(message = "O senha é obrigatório e nao pode ser nullo ou vazio")
        String senha
) {
    public UsuarioCriarDTO(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
