package com.bielsoft.desafioForumHubONE.controllers;

import com.bielsoft.desafioForumHubONE.dtos.topicoDtos.*;
import com.bielsoft.desafioForumHubONE.services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;


    @GetMapping
    public ResponseEntity<List<TopicoListarTodosDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoPorIdDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<TopicoCriarDTO> criarTopico(@RequestBody @Valid TopicoCriarDTO dados, UriComponentsBuilder uriBuilder) {
        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(dados.id()).toUri();
        return ResponseEntity.created(uri).body(service.criar(dados));
    }

    @PutMapping
    public ResponseEntity<TopicoAtualizarDTO> atualizarTopico(@RequestBody @Valid TopicoAtualizarDTO dados) {
        return ResponseEntity.ok(service.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
