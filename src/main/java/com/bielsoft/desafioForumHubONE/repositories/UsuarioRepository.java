package com.bielsoft.desafioForumHubONE.repositories;

import com.bielsoft.desafioForumHubONE.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
