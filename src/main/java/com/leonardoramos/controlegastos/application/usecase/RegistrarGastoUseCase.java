package com.leonardoramos.controlegastos.application.usecase;

import com.leonardoramos.controlegastos.application.dto.GastoInputDTO;
import com.leonardoramos.controlegastos.domain.model.Gasto;
import com.leonardoramos.controlegastos.domain.repository.GastoRepository;
import com.leonardoramos.controlegastos.domain.valueobject.Dinheiro;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrarGastoUseCase {

    private final GastoRepository repository;

    public RegistrarGastoUseCase(GastoRepository repository) {
        this.repository = repository;
    }

    public void executar(UUID userId, GastoInputDTO dto) {
        Gasto gasto = new Gasto(
                userId,
                dto.descricao,
                new Dinheiro(dto.valor),
                dto.categoria,
                dto.data
        );

        repository.salvar(gasto);
    }
}

