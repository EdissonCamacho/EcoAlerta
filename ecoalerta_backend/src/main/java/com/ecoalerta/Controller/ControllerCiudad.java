package com.ecoalerta.Controller;

import com.ecoalerta.Model.Ciudad;
import com.ecoalerta.Model.Departamento;
import com.ecoalerta.Services.Servdepartamento;
import com.ecoalerta.Services.ServiceCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ciudad")
public class ControllerCiudad {

    @Autowired
    private ServiceCiudad serviceCiudad;

    @Autowired
    private Servdepartamento servdepartamento;

    @GetMapping("getAll")
    public ResponseEntity<Iterable<Ciudad>> getAll(){
        return ResponseEntity.ok()
                .body(serviceCiudad.findAll());
    }


    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam String ciudad, @RequestParam Integer idDepartamento){
           Ciudad c = new Ciudad();
           c.setNombreCiudad(ciudad);
        Optional<Departamento> busq= servdepartamento.findById(idDepartamento);

           if(busq.isEmpty()){
               c.setIdDepartamentoFk(new Departamento());
               return ResponseEntity.status(400)
                       .body("Departamento no existe");

           }
        c.setIdDepartamentoFk(busq.get());

        return  ResponseEntity.status(201)
                .body(serviceCiudad.save(c));




    }

    @DeleteMapping("delete/{idCiudad}")
    public ResponseEntity<Object>  delete(@PathVariable Integer idCiudad){

        Optional<Ciudad> busq = serviceCiudad.findById(idCiudad);
        if (busq.isPresent()){
            serviceCiudad.deleteById(idCiudad);
         return    ResponseEntity.status(200)
                    .body(serviceCiudad.findAll());

        }

        return ResponseEntity.status(404)
                    .body("La ciudad no se encuentra registrad");


    }

    @PutMapping("update")
    public ResponseEntity<Object>  update(@RequestBody Ciudad ciudad ){

        Optional<Departamento> busq = servdepartamento.findById(ciudad.getIdDepartamentoFk().getId());
        Optional<Ciudad> busqCiudad = serviceCiudad.findById(ciudad.getId());
        if(busq.isPresent() && busqCiudad.isPresent()){
            return ResponseEntity.ok(serviceCiudad.save(ciudad));

        } else if (busqCiudad.isEmpty()) {
            return ResponseEntity.status(401)
                    .body("La ciudad no existe");


        }
        return ResponseEntity.status(401)
                .body("El Departamento no Existe");





    }

}
