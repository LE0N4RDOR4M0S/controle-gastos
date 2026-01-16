package com.leonardoramos.controlegastos.infra.security;

import com.leonardoramos.controlegastos.infra.persistence.entity.RefreshTokenEntity;
import com.leonardoramos.controlegastos.infra.persistence.repository.JpaRefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final JpaRefreshTokenRepository repository;

    public RefreshTokenService(JpaRefreshTokenRepository repository) {
        this.repository = repository;
    }

    public RefreshTokenEntity criar(UUID userId) {
        RefreshTokenEntity token = new RefreshTokenEntity(
                UUID.randomUUID(),
                userId,
                Instant.now().plus(30, ChronoUnit.DAYS)
        );
        return repository.save(token);
    }

    public UUID validar(UUID refreshToken) {
        RefreshTokenEntity token = repository.findById(refreshToken)
                .orElseThrow(() -> new RuntimeException("Refresh inválido"));

        if (token.getExpiresAt().isBefore(Instant.now())) {
            repository.delete(token);
            throw new RuntimeException("Refresh expirado");
        }

        return token.getUserId();
    }

    public void revogar(UUID refreshToken) {
        repository.deleteById(refreshToken);
    }
}
