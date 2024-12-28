package com.bielsoft.desafioForumHubONE.repositories;

import com.bielsoft.desafioForumHubONE.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
