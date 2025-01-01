package com.bielsoft.desafioForumHubONE.repositories;

import com.bielsoft.desafioForumHubONE.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
