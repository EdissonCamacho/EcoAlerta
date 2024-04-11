package com.ecoalerta.Controller;

import com.ecoalerta.Model.Departamento;
import com.ecoalerta.Model.Imagen;
import com.ecoalerta.Services.ServImagen;
import com.ecoalerta.Services.Servdepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("API/Imagen")
public class ControllerImagen {

    @Autowired
    ServImagen serv;

    // Metodo Get para obtener todos los registros de tabla Imagen
    @GetMapping("getAll")
    public Iterable<Imagen> getAll(){

        return serv.findAll();
    }

    // Metodo Get para obtener por id un registro de tabla Imagen
    @GetMapping("getImagenById/{id}")
    public Optional<Imagen> getImagenById(@PathVariable Integer id){

        return serv.findById(id);
    }

    // Metodo Delete mediante un Id especifico  para borrar ese registro de tabla Imagen
    @DeleteMapping("deleteImgById/{id}")
    public Iterable<Imagen> deleteImgById(@PathVariable Integer id ){

        serv.deleteById(id);
        return serv.findAll();
    }

    // Metodo Update mediante un Id especifico  para actualizar ese registro de tabla Imagen
    @PutMapping("UpdateId")
    public Iterable<Imagen> updateById(@RequestBody Imagen img ){
        // condicion para ver si existe
        serv.save(img);
        return serv.findAll();
    }

}
