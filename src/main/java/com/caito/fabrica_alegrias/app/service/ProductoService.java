package com.caito.fabrica_alegrias.app.service;

import com.caito.fabrica_alegrias.app.entity.Producto;
import com.caito.fabrica_alegrias.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // IMPLEMENTACION DE SERVICIOS

    // OBTENER TODOS

    @Transactional(readOnly = true)
    public List<Producto> getAll() {

        return productoRepository.findAll();
    }

    // OBTENER POR ID
    @Transactional(readOnly = true)
    public Producto getOne(Long id) {

        return productoRepository.getOne(id);
    }

    //GUARDAR

    @Transactional
    public void  save(Producto producto){

         productoRepository.save(producto);
    }

    // ELIMINAR

    @Transactional
    public void delete(Long id){

        productoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Producto findForNombre(String nombre){

        return productoRepository.findByNombre(nombre).get();
    }

    @Transactional(readOnly = true)
    public boolean existById(long id){

        return  productoRepository.existsById(id);
    }

    @Transactional(readOnly = true)
    public boolean existByNombre(String nombre){

        return productoRepository.existsByNombre(nombre);
    }
}
