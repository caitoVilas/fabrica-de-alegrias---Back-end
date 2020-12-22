package com.caito.fabrica_alegrias.app.controller;

import com.caito.fabrica_alegrias.app.entity.Producto;
import com.caito.fabrica_alegrias.app.security.dto.Mensaje;
import com.caito.fabrica_alegrias.app.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public List<Producto> getAll(){

       return productoService.getAll();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/ver/{id}")
    public ResponseEntity<?> getOne(@PathVariable("id") long id){

        if(! productoService.existById(id)){
            return new ResponseEntity(new Mensaje("El Producto no Existe!!!")
                    ,HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity(productoService.getOne(id), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/ver/{nombre}")
    public ResponseEntity<?> getByNombre(@PathVariable("nombre") String nombre){

       if(! productoService.existByNombre(nombre)){

           return new ResponseEntity(new Mensaje("El Producto no Exixte!!!"),
                   HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity(productoService.findForNombre(nombre),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/nuevo")
    public ResponseEntity<?> guardar(@Valid @RequestBody Producto producto, BindingResult result){

        if(result.hasErrors()){
            return new ResponseEntity(new Mensaje("Faltan Campos"),HttpStatus.BAD_REQUEST);
        }

        productoService.save(producto);

        return new ResponseEntity(new Mensaje("Producto Guardado"),HttpStatus.OK);
    }

}
