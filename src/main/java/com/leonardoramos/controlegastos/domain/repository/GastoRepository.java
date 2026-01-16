package com.leonardoramos.controlegastos.domain.repository;

import com.leonardoramos.controlegastos.domain.model.Gasto;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

public interface GastoRepository {

    void salvar(Gasto gasto);

    List<Gasto> listarPorUsuario(UUID userId);

    List<Gasto> listarPorUsuarioEMes(UUID userId, YearMonth mes);

    List<Gasto> listargastos();
}

