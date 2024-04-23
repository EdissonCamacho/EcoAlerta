package com.ecoalerta.Controller;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.ArticuloUsuario;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceArticuloUsuario;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/articuloUsuario")
public class ControllerArticuloUsuario {
    @Autowired
    ServiceArticuloUsuario serviceArticuloUsuario;
    @Autowired
    ServiceUsuario serviceUsuario;
    @Autowired
    ServiceArticulo serviceArticulo;

    @GetMapping("getAll")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.status(200).body(serviceArticuloUsuario.findAll());
    }
    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody ArticuloUsuario articuloUsuario){
        Optional<Usuario> usuario= serviceUsuario.findById(articuloUsuario.getIdUsuarioFk().getId());
        Optional<Articulo> articulo= serviceArticulo.findById(articuloUsuario.getIdArticuloFk().getId());
        if (usuario.isPresent() && articulo.isPresent()){
            ArticuloUsuario au = new ArticuloUsuario();
            au.setIdArticuloFk(articulo.get());
            au.setIdUsuarioFk(usuario.get());

            ResponseEntity.status(200).body(serviceArticuloUsuario.save(au));
        }
        return ResponseEntity.status(404).body("No se encontro articulo o usuario");

    }

    @DeleteMapping("deleteById/{idArticuloUsuario}")
    public ResponseEntity<Object> delete(@PathVariable Integer idArticuloUsuario){

        try {

          serviceArticulo.deleteById(idArticuloUsuario);
          return   ResponseEntity.status(200).body(serviceArticuloUsuario.findAll());

        }catch (Exception e){
            return ResponseEntity.status(404).body("Hubo un error al eliminar "+e);

        }
    }

    @GetMapping("getArticuloByUsuario")
    public Iterable<ArticuloUsuario> getArticuloByUsuario(@RequestBody Usuario u){
        return serviceArticuloUsuario.findArticuloUsuarioByIdUsuarioFk(u);

    }

}
