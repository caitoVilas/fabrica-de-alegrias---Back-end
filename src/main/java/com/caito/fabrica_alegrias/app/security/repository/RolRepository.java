package com.caito.fabrica_alegrias.app.security.repository;

import com.caito.fabrica_alegrias.app.security.entity.Rol;
import com.caito.fabrica_alegrias.app.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository  extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
