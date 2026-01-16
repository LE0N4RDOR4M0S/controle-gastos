package com.leonardoramos.controlegastos.infra.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "refresh_tokens")
public class RefreshTokenEntity {

    @Id
    private UUID id;

    private UUID userId;

    private Instant expiresAt;

    protected RefreshTokenEntity() {}

    public RefreshTokenEntity(UUID id, UUID userId, Instant expiresAt) {
        this.id = id;
        this.userId = userId;
        this.expiresAt = expiresAt;
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public Instant getExpiresAt() { return expiresAt; }
}
