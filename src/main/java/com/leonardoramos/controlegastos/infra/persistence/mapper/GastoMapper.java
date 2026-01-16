package com.leonardoramos.controlegastos.infra.persistence.mapper;

import com.leonardoramos.controlegastos.domain.model.Gasto;
import com.leonardoramos.controlegastos.domain.valueobject.Dinheiro;
import com.leonardoramos.controlegastos.infra.persistence.entity.GastoEntity;

public class GastoMapper {

    public static GastoEntity toEntity(Gasto gasto) {
        return new GastoEntity(
                gasto.getId(),
                gasto.getUserId(),
                gasto.getDescricao(),
                gasto.getValor().getValor(),
                gasto.getCategoria(),
                gasto.getData()
        );
    }

    public static Gasto toDomain(GastoEntity entity) {
        return new Gasto(
                entity.getUserId(),
                entity.getDescricao(),
                new Dinheiro(entity.getValor()),
                entity.getCategoria(),
                entity.getData()
        );
    }
}

