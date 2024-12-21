package com.bielsoft.desafioForumHubONE.controllers;

import com.bielsoft.desafioForumHubONE.dtos.TopicoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    public ResponseEntity<TopicoDTO> criarTopico(@RequestBody TopicoDTO dados){
        return ResponseEntity.ok(new TopicoDTO(dados.titulo(), dados.mensagem(), dados.autor(), dados.curso()));
    }

}
