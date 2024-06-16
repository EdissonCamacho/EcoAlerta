package com.ecoalerta.Controller.dto;

import com.ecoalerta.Model.Comentario;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Services.ServiceComentario;
import com.ecoalerta.Services.ServiceComentarioArticulo;
import com.ecoalerta.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/comentarioarticulo")

public class ControllerComentarioArticulo {

    @Autowired
    private ServiceUsuario serviceUsuario;
    @Autowired
    private ServiceComentario serviceComentario;
    @Autowired
    private ServiceComentarioArticulo serviceComentarioArticulo;


    @PostMapping("create")
    public ResponseEntity<Object> createComentario(@RequestParam String username,@RequestParam Integer idComentario){



  return null;

    }




}
