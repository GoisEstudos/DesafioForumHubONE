package com.bielsoft.desafioForumHubONE.services;

import com.bielsoft.desafioForumHubONE.entities.Usuario;
import com.bielsoft.desafioForumHubONE.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listarUsuario(){
        return repository.findAll();
    }

}
