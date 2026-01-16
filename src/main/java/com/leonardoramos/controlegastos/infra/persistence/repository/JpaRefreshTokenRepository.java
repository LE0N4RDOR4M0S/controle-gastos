package com.leonardoramos.controlegastos.infra.persistence.repository;

import com.leonardoramos.controlegastos.infra.persistence.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaRefreshTokenRepository extends JpaRepository<RefreshTokenEntity, UUID> {
}
