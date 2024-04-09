package com.ecoalerta.Controller;

import com.ecoalerta.Model.Departamento;
import com.ecoalerta.Model.Rol;
import com.ecoalerta.Services.Servdepartamento;
import com.ecoalerta.Services.ServiceRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("API/rol")
public class ControllerRol {


    @Autowired
    ServiceRol serv;

    // Metodo Get para obtener todos los registros de tabla Departamento
    @GetMapping("getAll")
    public Iterable<Rol> getAll(){


        return serv.findAll();
    }

    // Metodo Post para crear un registro en tabla Departamento
    @PostMapping("create")
    public Rol create(@RequestParam String rol ){

        Rol r = new Rol();
        r.setNombreRol(rol);
        return serv.save(r);
    }

    // Metodo Get para mediante un Id especifico  para obtener ese registro de tabla Departamento
    @GetMapping("getId/{id}")
    public Optional<Rol> getById(@PathVariable Integer id ){

        return serv.findById(id) ;
    }


    // Metodo Delete mediante un Id especifico  para borrar ese registro de tabla Departamento
    @DeleteMapping("deleteId/{id}")
    public Iterable<Rol> deleteById(@PathVariable Integer id){

        serv.deleteById(id);
        return serv.findAll();
    }

    // Metodo Update mediante un Id especifico  para actualzar ese registro de tabla Departamento
    @PutMapping("UpdateId")
    public Iterable<Rol> updateById(@RequestBody Rol rol ){

        serv.save(rol);
        return serv.findAll();
    }


}
