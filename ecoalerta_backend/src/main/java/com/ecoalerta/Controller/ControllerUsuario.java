package com.ecoalerta.Controller;

import com.ecoalerta.Model.Ciudad;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceCiudad;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/usuario")
public class ControllerUsuario {
    @Autowired
    ServiceUsuario serviceUsuario;
    @Autowired
    ServiceCiudad serviceCiudad;

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody Usuario objUsuario){
        Optional<Ciudad> ciudad = serviceCiudad.findById(objUsuario.getIdCiudadFk().getId());
        if(ciudad.isEmpty()){
          return  ResponseEntity.status(404).body("No se encontro la ciudad");
        }
        objUsuario.setIdCiudadFk(ciudad.get());
      return   ResponseEntity.status(200).body(serviceUsuario.save(objUsuario));
    }
    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestBody Usuario objUsuario){
        Optional<Ciudad> c = serviceCiudad.findById(objUsuario.getIdCiudadFk().getId());
        Optional<Usuario> u = serviceUsuario.findById(objUsuario.getId());
        if(c.isEmpty() || u.isEmpty()){
            return  ResponseEntity.status(404).body("No se encontro la ciudad o usuario");
        }
        objUsuario.setIdCiudadFk(c.get());
        return   ResponseEntity.status(200).body(serviceUsuario.save(objUsuario));
    }

    @GetMapping("getAll")
    public Iterable<Usuario> getAll(){
        return serviceUsuario.findAll();
    }

    @DeleteMapping("deleteById/{idUsuario}")
    public Iterable<Usuario> delete(@PathVariable Integer idUsuario){
        serviceUsuario.deleteById(idUsuario);
        return serviceUsuario.findAll();
    }
    @GetMapping("getById/{idUsuario}")
    public Optional<Usuario> getById(@PathVariable Integer idUsuario){
        return serviceUsuario.findById(idUsuario);
    }


}
