package com.bielsoft.desafioForumHubONE.dtos;

import com.bielsoft.desafioForumHubONE.entities.Usuario;

import java.util.List;

public record UsuarioDTO(Long id, String nome , String email, String senha, List<PerfilDTO> perfil) {

    public UsuarioDTO(Usuario usuario) {
        this(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getSenha(),
            usuario.getPerfil()
        );
    }
}
