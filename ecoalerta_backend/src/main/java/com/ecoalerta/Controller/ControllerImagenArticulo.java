package com.ecoalerta.Controller;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Imagen;
import com.ecoalerta.Model.Imagenarticulo;
import com.ecoalerta.Operaciones.ImagenArticulo;
import com.ecoalerta.Services.ServImagen;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceImagenArticulo;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/imagenArticulo")
public class ControllerImagenArticulo {
    @Autowired
    ServiceImagenArticulo serviceImagenArticulo;
    @Autowired
    ServiceArticulo serviceArticulo;
    @Autowired
    ServImagen servImagen;

    public static ImagenArticulo imagenArticulo;

    @GetMapping("getAll")
    public Iterable<Imagenarticulo> getAll(){
        return serviceImagenArticulo.findAll();
    }
    @GetMapping("getByArticulo/{idArticulo}")
    public  ResponseEntity<Object>  getByArticulo(@PathVariable Integer idArticulo){
        Optional<Articulo> a = serviceArticulo.findById(idArticulo);
        if (a.isPresent()){
        return  ResponseEntity.status(200).body(serviceImagenArticulo.findByIdArticuloFk(a.get()));
        }

        return ResponseEntity.status(404).body("No se encontraron Imagenes para el articulo "+ idArticulo );

    }
    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam Integer idArticulo,@RequestParam Integer idImagen){
        imagenArticulo= new ImagenArticulo();
       return imagenArticulo.insertar(idImagen,idArticulo,servImagen,serviceArticulo,serviceImagenArticulo);

    }
    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestParam Integer idArticulo,@RequestParam Integer idImagen){
        imagenArticulo= new ImagenArticulo();
        return imagenArticulo.insertar(idImagen,idArticulo,servImagen,serviceArticulo,serviceImagenArticulo);

    }
    @DeleteMapping("deleteById/{idImagenArticulo}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer idImagenArticulo){
        try {
            serviceImagenArticulo.deleteById(idImagenArticulo);
           return ResponseEntity.status(200).body(serviceImagenArticulo.findAll());
        }catch (Exception e){
           return ResponseEntity.status(404).body("No se pudo eliminar "+e);
        }

    }



}
