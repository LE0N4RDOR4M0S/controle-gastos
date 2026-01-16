package com.leonardoramos.controlegastos.application.dto;

import lombok.Data;

public class RegistroDTO {
    public String email;
    public String senha;
    public String role;

    public RegistroDTO(String email, String senha, String role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }
}

