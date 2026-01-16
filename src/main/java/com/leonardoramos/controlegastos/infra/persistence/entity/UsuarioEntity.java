package com.leonardoramos.controlegastos.infra.persistence.entity;

import com.leonardoramos.controlegastos.domain.valueobject.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity extends AuditableEntity{

    @Id
    private UUID id;

    @Column(unique = true)
    private String email;

    private String senhaHash;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
}

