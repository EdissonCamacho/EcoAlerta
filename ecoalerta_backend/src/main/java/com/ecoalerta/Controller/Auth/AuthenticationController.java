package com.ecoalerta.Controller.Auth;

import com.ecoalerta.Controller.dto.AuthResponse;
import com.ecoalerta.Model.Usuario;
import com.ecoalerta.Operaciones.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecoalerta.Controller.dto.AuthLoginRequest;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario){
        return userDetailService.createUser(usuario);
    }
    @PostMapping("/login")
    public String login(@RequestBody  AuthLoginRequest userRequest){
        return this.userDetailService.loginUser(userRequest);
    }
}
