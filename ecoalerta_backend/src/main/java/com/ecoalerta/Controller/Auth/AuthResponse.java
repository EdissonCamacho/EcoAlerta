package com.ecoalerta.Controller.Auth;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","jwt"})
public record AuthResponse (
    String username,
    String jwt
){
}
