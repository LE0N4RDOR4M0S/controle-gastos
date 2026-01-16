package com.leonardoramos.controlegastos.domain.valueobject;

import java.math.BigDecimal;

public class Dinheiro {

    private final BigDecimal valor;

    public Dinheiro(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
