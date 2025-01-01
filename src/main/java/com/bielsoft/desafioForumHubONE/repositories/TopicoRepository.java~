package com.bielsoft.desafioForumHubONE.repositories;

import com.bielsoft.desafioForumHubONE.entities.Topico;
import com.bielsoft.desafioForumHubONE.enums.StatusEnum;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloIgnoreCase(String titulo);

    List<Topico> findAllByStatusOrderByDataCriacaoAsc(StatusEnum status,Pageable pageable);

    Optional<Topico> findByIdAndStatus(Long id, StatusEnum status);
}
