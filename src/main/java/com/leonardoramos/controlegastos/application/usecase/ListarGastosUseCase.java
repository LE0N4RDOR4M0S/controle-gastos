package com.leonardoramos.controlegastos.application.usecase;

import com.leonardoramos.controlegastos.application.dto.GastoInputDTO;
import com.leonardoramos.controlegastos.domain.model.Gasto;
import com.leonardoramos.controlegastos.domain.repository.GastoRepository;
import com.leonardoramos.controlegastos.domain.valueobject.Dinheiro;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Service
public class ListarGastosUseCase {

    private final GastoRepository repository;

    public ListarGastosUseCase(GastoRepository repository) {
        this.repository = repository;
    }

    public List<Gasto> listarPorUsuario(UUID userId) {
        return repository.listarPorUsuario(userId);
    }

    public List<Gasto> listarPorUsuarioEMes(UUID userId, YearMonth mes) {
        return repository.listarPorUsuarioEMes(userId, mes);
    }

    public List<Gasto> listarGastos() {
        return repository.listargastos();
    }
}
