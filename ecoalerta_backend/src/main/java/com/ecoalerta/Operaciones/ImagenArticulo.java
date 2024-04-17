package com.ecoalerta.Operaciones;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Imagen;
import com.ecoalerta.Model.Imagenarticulo;
import com.ecoalerta.Services.ServImagen;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceImagenArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class ImagenArticulo {



    public ResponseEntity<Object> insertar(Integer idImagen, Integer idArticulo,ServImagen servImagen,ServiceArticulo serviceArticulo,ServiceImagenArticulo serviceImagenArticulo){
        Optional<Imagen> i = servImagen.findById(idImagen);
        Optional<Articulo> a= serviceArticulo.findById(idArticulo);
        if (a.isPresent() && i.isPresent()){
            Imagenarticulo ia = new Imagenarticulo();
            ia.setIdImagenFk(i.get());
            ia.setIdArticuloFk(a.get());
            return ResponseEntity.status(200).body(serviceImagenArticulo.save(ia));
        }else{
            return ResponseEntity.status(404).body("No se encontro imagen o articulo");
        }
    }
}
