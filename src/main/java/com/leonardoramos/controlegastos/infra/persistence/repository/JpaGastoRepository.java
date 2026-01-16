package com.leonardoramos.controlegastos.infra.persistence.repository;

import com.leonardoramos.controlegastos.domain.model.Gasto;
import com.leonardoramos.controlegastos.infra.persistence.entity.GastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

public interface JpaGastoRepository extends JpaRepository<GastoEntity, UUID> {

    List<GastoEntity> findByUserId(UUID userId);

    List<GastoEntity> findByUserIdAndDataBetween(
            UUID userId,
            LocalDate inicio,
            LocalDate fim
    );
}

