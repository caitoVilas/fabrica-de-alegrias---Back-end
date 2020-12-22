package com.caito.fabrica_alegrias.app.security.repository;

import com.caito.fabrica_alegrias.app.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nommbreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByemail(String email);
}
