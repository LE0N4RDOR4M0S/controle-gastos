package com.leonardoramos.controlegastos.application.dto;

import com.leonardoramos.controlegastos.infra.persistence.entity.RefreshTokenEntity;

import java.time.Instant;
import java.util.UUID;

public class RefreshDTO {
    private final UUID userId;
    private final Instant expiresAt;
    private UUID refreshToken;

    public RefreshDTO(UUID userId, Instant expiresAt, UUID refreshToken) {
        this.userId = userId;
        this.expiresAt = expiresAt;
        this.refreshToken = refreshToken;
    }

    public UUID getRefreshToken() {
        return refreshToken;
    }
}
