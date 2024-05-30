package com.ecoalerta.Controller;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Seccion;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceSeccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articulo")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControllerArticulo {
    @Autowired
    ServiceSeccion serviceSeccion;
    @Autowired
    ServiceArticulo serviceArticulo;



    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam Integer idSeccion,@RequestParam String tituloArticulo,@RequestParam String contenidoArticulo){
        Articulo a = new Articulo();
        Optional<Seccion> s = serviceSeccion.findById(idSeccion);
        if (s.isPresent()){
            a.setIdSeccionFk(s.get());
            a.setTituloArticulo(tituloArticulo);
            a.setInformacionArticulo(contenidoArticulo);
           return ResponseEntity.status(201)
                   .body(serviceArticulo.save(a));


        }
        return ResponseEntity.status(404)
                .body("No se encontro la Seccion");

    }
    @GetMapping("getAll")
    public Iterable<Articulo> getAll(){
        return serviceArticulo.findAll();
    }

    @GetMapping("getByIdSeccion/{id}")
    public ResponseEntity<Object> getByIdSeccion(@PathVariable int id){
          Optional<Seccion> secciona = serviceSeccion.findById(id);
          if(secciona.isPresent()){
              Iterable<Articulo>  a= serviceArticulo.findByidSeccionFk( secciona.get());

          return ResponseEntity.status(200).body(a);
          }
          return ResponseEntity.status(400).body("No se encontraron datos");

    }

    @GetMapping("delete/{idArticulo}")
    public ResponseEntity<Object> delete(@PathVariable Integer idArticulo){
        serviceArticulo.deleteById(idArticulo);
    return ResponseEntity.ok()
             .body(serviceArticulo.findAll());

    }

    @GetMapping("update")
    public ResponseEntity<Object> update(@RequestParam Integer idArticulo,@RequestParam Integer idSeccion,@RequestParam String titulo, @RequestParam String contenido){

        Optional<Articulo> busqArticulo = serviceArticulo.findById(idArticulo);
        Optional<Seccion> s = serviceSeccion.findById(idSeccion);
        if (s.isPresent() && busqArticulo.isPresent()){
            Articulo a = new Articulo();
            a.setId(idArticulo);
            a.setIdSeccionFk(s.get());
            a.setTituloArticulo(titulo);
            a.setInformacionArticulo(contenido);
            return ResponseEntity.status(201)
                    .body(serviceArticulo.save(a));


        } else if (busqArticulo.isEmpty()) {
            return ResponseEntity.status(404)
                    .body("No se encontro la Articulo");


        }
        return ResponseEntity.status(404)
                .body("No se encontro la Seccion");



    }



}
