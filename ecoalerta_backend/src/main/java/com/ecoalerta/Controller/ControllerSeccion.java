package com.ecoalerta.Controller;

import com.ecoalerta.Model.Seccion;
import com.ecoalerta.Services.ServiceSeccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/seccion")
@CrossOrigin(origins = "http://localhost:4200/")
public class ControllerSeccion {
    @Autowired
    ServiceSeccion serviceSeccion;

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam String nombreSeccion){
            try{
                Seccion s = new Seccion();
                s.setNombreSeccion(nombreSeccion);
               return ResponseEntity.status(201)
                       .body(serviceSeccion.save(s));

            }catch (Exception e){
                return  ResponseEntity.badRequest()
                        .body(e);

            }
    }
    @GetMapping("getAll")
    public ResponseEntity<Iterable<Seccion>> getAll(){
        return ResponseEntity.ok()
                .body(serviceSeccion.findAll());

    }

    @DeleteMapping("delete/{idSeccion}")
    public ResponseEntity<Object> delete(@PathVariable Integer idSeccion){

            serviceSeccion.deleteById(idSeccion);
         return   ResponseEntity.ok()
                   .body(serviceSeccion.findAll());

    }
    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody Seccion seccion){
        Optional<Seccion> bus = serviceSeccion.findById(seccion.getId());
        if(bus.isEmpty()){
            return ResponseEntity.status(404)
                    .body("No se encontro la Seccion");
        }
        return ResponseEntity.ok()
                .body(serviceSeccion.save(seccion));
    }


}



