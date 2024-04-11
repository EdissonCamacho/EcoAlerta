package com.ecoalerta.Controller;

import com.ecoalerta.Model.Comentario;
import com.ecoalerta.Services.ServiceComentario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("API/Comentario")
public class ControllerComentario {
    @Autowired
    ServiceComentario serv;

    @GetMapping("getAll")
    public Iterable<Comentario> getAll(){

        return serv.findAll();
    }

    @PostMapping("create")
    public Comentario create(@RequestParam String com){

        Comentario c = new Comentario();
        c.setComentario(com);
        return serv.save(c);

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
