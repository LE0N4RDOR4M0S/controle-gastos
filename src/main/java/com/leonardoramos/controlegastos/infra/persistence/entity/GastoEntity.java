package com.leonardoramos.controlegastos.infra.persistence.entity;

import com.leonardoramos.controlegastos.domain.valueobject.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "gastos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GastoEntity extends AuditableEntity{

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, updatable = false)
    private UUID userId;

    private String descricao;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private LocalDate data;
}

