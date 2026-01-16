package com.leonardoramos.controlegastos.application.dto;

import java.util.UUID;

public class TokenResponse {
    public String accessToken;
    public UUID refreshToken;

    public TokenResponse(String token, UUID refreshToken) {
        this.accessToken = token;
        this.refreshToken = refreshToken;
    }
}
