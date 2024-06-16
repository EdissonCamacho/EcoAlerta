package com.ecoalerta.Controller;

import com.ecoalerta.Model.Comentario;
import com.ecoalerta.Services.ServiceComentario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("API/Comentario")
public class ControllerComentario {
    @Autowired
    private ServiceComentario serv;

    @GetMapping("getAll")
    public Iterable<Comentario> getAll(){

        return serv.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@ResponseBody Comentario com){

        Comentario comentario = serv.save(com);
        return ResponseEntity.status(200).body(comentario);

    }

    @GetMapping("getId/{id}")

    public Optional<Comentario> getById(@PathVariable Integer id){

        return serv.findById(id);
    }

    @DeleteMapping("deleteId/{id}")
    public Iterable<Comentario> deleteById(@PathVariable Integer id){

        serv.deleteById(id);
        return serv.findAll();

    }

    @PutMapping("UpdateId")
    public Iterable<Comentario> updateById(@RequestBody Comentario com){

        serv.save(com);
        return serv.findAll();
    }
}
