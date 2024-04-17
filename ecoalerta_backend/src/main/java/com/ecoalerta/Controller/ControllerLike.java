package com.ecoalerta.Controller;

import com.ecoalerta.Model.Articulo;
import com.ecoalerta.Model.Like;
import com.ecoalerta.Operaciones.OperacionesLike;
import com.ecoalerta.Services.ServiceArticulo;
import com.ecoalerta.Services.ServiceLike;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/like")
public class ControllerLike  {
    @Autowired
    ServiceLike serviceLike;
    @Autowired
    ServiceArticulo serviceArticulo;
    @Autowired
    ServiceUsuario serviceUsuario;
    @Autowired
    OperacionesLike operacionesLike;



    @GetMapping("getAll")
    public Iterable<Like> getall(){
        return serviceLike.findAll();
    }
    @GetMapping("getLikeByArticulo/{idArticulo}")
    public ResponseEntity<Object> getLikeByArticulo(@PathVariable Integer idArticulo){
        Optional<Articulo> l = serviceArticulo.findById(idArticulo);
        if (l.isPresent()){
            return ResponseEntity.status(200).body(serviceLike.findByIdArticuloFk(l.get()));

        }
        return ResponseEntity.status(404).body("El articulo no existe");

    }
    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestParam Integer idArticulo,@RequestParam Integer idUsuario){
      return   operacionesLike.insertar(idArticulo,idUsuario,serviceUsuario,serviceArticulo,serviceLike);
    }
    @PutMapping("update")
    public ResponseEntity<Object> update(@RequestParam Integer idArticulo,@RequestParam Integer idUsuario){
        return   operacionesLike.insertar(idArticulo,idUsuario,serviceUsuario,serviceArticulo,serviceLike);
    }
    @DeleteMapping("deleteById/{idLike}")
    public ResponseEntity<Object> deleteByid(@PathVariable Integer idLike){
        Optional<Like> like = serviceLike.findById(idLike);
        if (like.isPresent()){
        try {
            serviceLike.deleteById(idLike);
         return    ResponseEntity.status(200).body(serviceLike.findAll());
        }catch (Exception e){
            return  ResponseEntity.status(404).body("No se pudo eliminar "+e.toString());
        }
        }
        return ResponseEntity.status(404).body("No existe el registro "+idLike);

    }



}
