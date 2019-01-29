package com.auth.customjwt.payload.auth;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String token = "Bearer ";

    public JwtAuthenticationResponse(String token) {
        this.token += token;
    }
}
