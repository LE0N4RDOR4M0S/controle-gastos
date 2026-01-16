package com.leonardoramos.controlegastos.application.dto;

import com.leonardoramos.controlegastos.domain.valueobject.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GastoInputDTO {

    public String descricao;
    public BigDecimal valor;
    public Categoria categoria;
    public LocalDate data;
}

