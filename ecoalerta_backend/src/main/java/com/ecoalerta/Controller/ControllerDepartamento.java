package com.ecoalerta.Controller;

import com.ecoalerta.Model.Departamento;
import com.ecoalerta.Services.Servdepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("API/Departamento")
public class ControllerDepartamento {


    @Autowired
    Servdepartamento serv;

    // Metodo Get para obtener todos los registros de tabla Departamento
    @GetMapping("getAll")
    public Iterable<Departamento> getAll(){


        return serv.findAll();
    }

    // Metodo Post para crear un registro en tabla Departamento
    @PostMapping("create")
    public Departamento create(@RequestParam String dep ){

        Departamento d = new Departamento();
        d.setNombreDepartamento(dep);
        return serv.save(d) ;
    }

    // Metodo Get para mediante un Id especifico  para obtener ese registro de tabla Departamento
    @GetMapping("getId/{id}")
    public Optional<Departamento> getById(@PathVariable Integer id ){

        return serv.findById(id) ;
    }

//    // Metodo Get  mediante nombre especifico  para obtener ese registro de tabla Departamento
//    @GetMapping("getDep/")
//    public Iterable<Departamento> getByName(@RequestParam String dep ){
//
//        return serv.findAll(nombreDepartamento,dep) ;
//    }

    // Metodo Delete mediante un Id especifico  para borrar ese registro de tabla Departamento
    @DeleteMapping("deleteId/{id}")
    public Iterable<Departamento> deleteById(@PathVariable Integer id ){

        serv.deleteById(id);
        return serv.findAll();
    }

    // Metodo Update mediante un Id especifico  para actualziar ese registro de tabla Departamento
    @PutMapping("UpdateId")
    public Iterable<Departamento> updateById(@RequestBody Departamento dep ){

        serv.save(dep);
        return serv.findAll();
    }


}
