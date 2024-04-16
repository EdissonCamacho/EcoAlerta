package com.ecoalerta.Controller;

import com.ecoalerta.Model.Rol;
import com.ecoalerta.Model.RolUsuario;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceRol;
import com.ecoalerta.Services.ServiceRolUsuario;
import com.ecoalerta.Services.ServiceUsuario;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("API/rolusuario")
public class ControllerRolUsuario
{
    @Autowired
    ServiceRolUsuario servRolUsuario;
    @Autowired
    ServiceUsuario servUsuario;
    @Autowired
    ServiceRol servRol;

    @GetMapping("getAll")
    public Iterable<RolUsuario> getAll(){
        return servRolUsuario.findAll();
    }
    @PostMapping("create")
    public ResponseEntity <Object> create(@RequestParam Integer idUsuario, @RequestParam Integer idRol){
        Optional<Usuario> usuario = servUsuario.findById(idUsuario);
        if (usuario.isEmpty()) {
            return ResponseEntity.status(404).body("No se encontro el usuraio");

        }
        else {
            Optional<Rol> rol = servRol.findById(idRol);
            if (rol.isPresent()){
                RolUsuario user = new RolUsuario();
                user.setIdRolFk(rol.get());
                user.setIdUsuarioFk(usuario.get());
                return ResponseEntity.status(200).body(servRolUsuario.save(user));

            }
            return ResponseEntity.status(404).body("No se encontro el Rol");
        }
    }
}
