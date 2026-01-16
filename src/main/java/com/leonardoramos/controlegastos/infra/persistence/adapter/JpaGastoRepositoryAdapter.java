package com.leonardoramos.controlegastos.infra.persistence.adapter;

import com.leonardoramos.controlegastos.domain.model.Gasto;
import com.leonardoramos.controlegastos.domain.repository.GastoRepository;
import com.leonardoramos.controlegastos.infra.persistence.mapper.GastoMapper;
import com.leonardoramos.controlegastos.infra.persistence.repository.JpaGastoRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@Repository
public class JpaGastoRepositoryAdapter implements GastoRepository {

    private final JpaGastoRepository jpa;

    public JpaGastoRepositoryAdapter(JpaGastoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void salvar(Gasto gasto) {
        jpa.save(GastoMapper.toEntity(gasto));
    }

    @Override
    public List<Gasto> listarPorUsuario(UUID userId) {
        return jpa.findByUserId(userId)
                .stream()
                .map(GastoMapper::toDomain)
                .toList();
    }

    @Override
    public List<Gasto> listarPorUsuarioEMes(UUID userId, YearMonth mes) {
        return jpa.findByUserIdAndDataBetween(
                        userId,
                        mes.atDay(1),
                        mes.atEndOfMonth()
                )
                .stream()
                .map(GastoMapper::toDomain)
                .toList();
    }

    @Override
    public List<Gasto> listargastos() {
        return jpa.findAll()
                .stream()
                .map(GastoMapper::toDomain)
                .toList();
    }
}

