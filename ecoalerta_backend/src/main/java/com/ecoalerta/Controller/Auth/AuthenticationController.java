package com.ecoalerta.Controller.Auth;

import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Operaciones.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecoalerta.Controller.dto.AuthLoginRequest;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthenticationController {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody Usuario usuario){
        AuthResponse ar= new AuthResponse(usuario.getUsuario(),userDetailService.createUser(usuario));
        return new ResponseEntity<>(ar,HttpStatus.OK);




    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody  AuthLoginRequest userRequest){
        AuthResponse ar= new AuthResponse(userRequest.username(),this.userDetailService.loginUser(userRequest));



        return new ResponseEntity<>(ar,HttpStatus.OK);
    }
}
