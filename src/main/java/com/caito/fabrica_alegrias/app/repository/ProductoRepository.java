package com.caito.fabrica_alegrias.app.repository;

import com.caito.fabrica_alegrias.app.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public Optional<Producto> findByNombre(String nombre);
    public boolean existsById(long id);
    public boolean existsByNombre(String nombre);
}
