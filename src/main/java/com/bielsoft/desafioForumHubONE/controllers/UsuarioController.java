package com.bielsoft.desafioForumHubONE.controllers;

import com.bielsoft.desafioForumHubONE.dtos.usuarioDtos.UsuarioCriarDTO;
import com.bielsoft.desafioForumHubONE.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioCriarDTO> criar(@RequestBody @Valid UsuarioCriarDTO dto) {
        return ResponseEntity.ok(service.criarUsuario(dto));
    }

}
