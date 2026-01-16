package com.leonardoramos.controlegastos.domain.model;

import com.leonardoramos.controlegastos.domain.valueobject.Role;

import java.util.Set;
import java.util.UUID;

public class Usuario {

    private final UUID id;
    private final String email;
    private final String senhaHash;
    private final Set<Role> roles;

    public Usuario(UUID id, String email, String senhaHash, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.senhaHash = senhaHash;
        this.roles = roles;
    }

    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getSenhaHash() { return senhaHash; }
    public Set<Role> getRoles() { return roles; }
}
