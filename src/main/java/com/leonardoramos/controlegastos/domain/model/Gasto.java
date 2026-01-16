package com.leonardoramos.controlegastos.domain.model;

import com.leonardoramos.controlegastos.domain.valueobject.Categoria;
import com.leonardoramos.controlegastos.domain.valueobject.Dinheiro;

import java.time.LocalDate;
import java.util.UUID;

public class Gasto {

    private final UUID id;
    private final UUID userId;
    private final String descricao;
    private final Dinheiro valor;
    private final Categoria categoria;
    private final LocalDate data;

    public Gasto(UUID userId, String descricao, Dinheiro valor, Categoria categoria, LocalDate data) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição obrigatória");
        }
        if (userId == null) {
            throw new IllegalArgumentException("Usuário obrigatório");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição obrigatória");
        }
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getDescricao() {
        return descricao;
    }

    public Dinheiro getValor() {
        return valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getData() {
        return data;
    }
}


