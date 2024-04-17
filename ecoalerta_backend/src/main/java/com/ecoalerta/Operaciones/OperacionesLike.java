package com.ecoalerta.Operaciones;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Like;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceLike;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OperacionesLike {

    public ResponseEntity<Object> insertar(Integer idArticulo, Integer idUsuario, ServiceUsuario serviceUsuario, ServiceArticulo serviceArticulo, ServiceLike serviceLike) {
        Optional<Usuario> u = serviceUsuario.findById(idUsuario);
        Optional<Articulo> a = serviceArticulo.findById(idArticulo);
        if(u.isPresent() && a.isPresent()){
            Like l = new Like();
            l.setIdArticuloFk(a.get());
            l.setIdUsuarioFk(u.get());
           return ResponseEntity.status(200).body(serviceLike.save(l));
        }
        return ResponseEntity.status(404).body("No se encontro articulo o Usuario");


    }

}
