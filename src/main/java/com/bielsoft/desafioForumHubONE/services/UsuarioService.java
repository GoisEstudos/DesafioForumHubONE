package com.bielsoft.desafioForumHubONE.services;

import com.bielsoft.desafioForumHubONE.dtos.usuarioDtos.UsuarioCriarDTO;
import com.bielsoft.desafioForumHubONE.entities.Perfil;
import com.bielsoft.desafioForumHubONE.entities.Usuario;
import com.bielsoft.desafioForumHubONE.repositories.PerfilRepository;
import com.bielsoft.desafioForumHubONE.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    public UsuarioCriarDTO criarUsuario(UsuarioCriarDTO dto) {

        Perfil perfil = perfilRepository.findById(2L).orElseThrow(RuntimeException::new);
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setPerfil(perfil);
        usuarioRepository.save(usuario);

        return new UsuarioCriarDTO(usuario);
    }

}
