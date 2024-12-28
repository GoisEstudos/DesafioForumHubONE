package com.bielsoft.desafioForumHubONE.services;

import com.bielsoft.desafioForumHubONE.Exception.IdNaoEcontradoException;
import com.bielsoft.desafioForumHubONE.Exception.TituloCadastradoException;
import com.bielsoft.desafioForumHubONE.dtos.topicoDtos.TopicoAtualizarDTO;
import com.bielsoft.desafioForumHubONE.dtos.topicoDtos.TopicoCriarDTO;
import com.bielsoft.desafioForumHubONE.dtos.topicoDtos.TopicoListarTodosDTO;
import com.bielsoft.desafioForumHubONE.dtos.topicoDtos.TopicoPorIdDTO;
import com.bielsoft.desafioForumHubONE.entities.Curso;
import com.bielsoft.desafioForumHubONE.entities.Topico;
import com.bielsoft.desafioForumHubONE.entities.Usuario;
import com.bielsoft.desafioForumHubONE.enums.StatusEnum;
import com.bielsoft.desafioForumHubONE.repositories.CursoRepository;
import com.bielsoft.desafioForumHubONE.repositories.TopicoRepository;
import com.bielsoft.desafioForumHubONE.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, UsuarioRepository usuarioRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<TopicoListarTodosDTO> listar() {
        StatusEnum statusAtivo = StatusEnum.ATIVO;
        Pageable pageable = PageRequest.of(0, 10);
        return topicoRepository.findAllByStatusOrderByDataCriacaoAsc(statusAtivo,pageable).stream().map(TopicoListarTodosDTO::new).collect(Collectors.toList());
    }

    public TopicoPorIdDTO listarPorId(Long id) {
        StatusEnum statusAtivo = StatusEnum.ATIVO;
        var topico = topicoRepository.findByIdAndStatus(id, statusAtivo).orElseThrow(() -> new IdNaoEcontradoException("Id nao encontrado"));

        return new TopicoPorIdDTO(topico);
    }

    public TopicoCriarDTO criar(@Valid TopicoCriarDTO dto) {
        if (existeTituloCriar(dto)) {
            throw new TituloCadastradoException("Titulo ja cadastrado");
        }
        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(RuntimeException::new);
        Curso curso = cursoRepository.findById(dto.cursoId()).orElseThrow(RuntimeException::new);

        Topico topico = new Topico();
        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setUsuario(usuario);
        topico.setCurso(curso);

        Topico topicoSalvo = topicoRepository.save(topico);

        return new TopicoCriarDTO(topicoSalvo);
    }

    public TopicoAtualizarDTO atualizar(TopicoAtualizarDTO dto) {
        if (existeTituloAtualizar(dto)) {
            throw new TituloCadastradoException("Titulo ja cadastrado");
        }

        Topico topico = topicoRepository.findById(dto.id()).
                orElseThrow(() -> new IdNaoEcontradoException("Id do topico nao encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new IdNaoEcontradoException("Id do usuario nao encontrado"));
        Curso curso = cursoRepository.findById(dto.cursoId()).orElseThrow(() -> new IdNaoEcontradoException("Id do curso nao encontrado"));

        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setUsuario(usuario);
        topico.setCurso(curso);

        topicoRepository.save(topico);

        return new TopicoAtualizarDTO(topico);
    }


    public void deletar(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new IdNaoEcontradoException("Id não encontrado"));

        topico.setStatus(StatusEnum.INATIVO);

        topicoRepository.save(topico);
    }

    public Boolean existeTituloCriar(TopicoCriarDTO dto) {
        return topicoRepository.existsByTituloIgnoreCase(dto.titulo());
    }

    public Boolean existeTituloAtualizar(TopicoAtualizarDTO dto) {
        return topicoRepository.existsByTituloIgnoreCase(dto.titulo());
    }
}
