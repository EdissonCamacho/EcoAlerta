package com.ecoalerta.Controller;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Comentarioarticulo;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceComentarioArticulo;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("API/ComentarioArticulo")
@CrossOrigin(origins = "http://localhost:4200")

public class ControllerComentarioArticulo {
    @Autowired
    private ServiceComentarioArticulo serviceComentarioArticulo;

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    private ServiceArticulo serviceArticulo;


    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody Comentarioarticulo comentarioarticulo){
        Optional<Usuario> user = serviceUsuario.findByUsuario(comentarioarticulo.getIdUsuarioFk().getUsuario());
            Optional<Articulo> articulo = serviceArticulo.findById(comentarioarticulo.getIdArticuloFk().getId());
        if(user.isPresent() && articulo.isPresent()){
            comentarioarticulo.setIdUsuarioFk(user.get());
            comentarioarticulo.setIdArticuloFk(articulo.get());
            return ResponseEntity.status(200).body(serviceComentarioArticulo.save(comentarioarticulo));

        }
        return ResponseEntity.badRequest().body("No se pudo crear comentario");

    }
    @GetMapping("getAll")
    public  Iterable<Comentarioarticulo> getAll(){
        return serviceComentarioArticulo.findAll();
    }
    @GetMapping("getByArticulo/{id}")
    public Iterable<Comentarioarticulo> getByArticulo(@PathVariable Integer id){
        Optional<Articulo> ar = serviceArticulo.findById(id);
        if (ar.isPresent()){
            return serviceComentarioArticulo.findByidArticuloFk(ar.get());
        }
        return serviceComentarioArticulo.findByidArticuloFk(ar.get());

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try{
            serviceComentarioArticulo.deleteById(id);
          return   ResponseEntity.status(200).body("Eliminado existosamente");
        } catch (Exception e){
          return ResponseEntity.badRequest().body(e.toString());
        }
    }


}
