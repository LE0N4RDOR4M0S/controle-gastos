package com.leonardoramos.controlegastos.infra.api;

import com.leonardoramos.controlegastos.application.dto.GastoInputDTO;
import com.leonardoramos.controlegastos.application.usecase.ListarGastosUseCase;
import com.leonardoramos.controlegastos.application.usecase.RegistrarGastoUseCase;
import com.leonardoramos.controlegastos.domain.model.Gasto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/gastos")
public class GastoController {

    private final RegistrarGastoUseCase registrar;
    private final ListarGastosUseCase listar;

    public GastoController(
            RegistrarGastoUseCase registrar,
            ListarGastosUseCase listar
    ) {
        this.registrar = registrar;
        this.listar = listar;
    }

    private UUID getUserId() {
        return (UUID) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    @PostMapping
    public void criar(@RequestBody GastoInputDTO dto) {
        registrar.executar(getUserId(), dto);
    }

    @GetMapping
    public List<Gasto> listarTodos() {
        return listar.listarPorUsuario(getUserId());
    }

    @GetMapping("/mes/{mes}")
    public List<Gasto> listarPorMes(@PathVariable String mes) {
        return listar.listarPorUsuarioEMes(
                getUserId(),
                YearMonth.parse(mes)
        );
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/relatorio")
    public List<Gasto> relatorioAdmin() {
        return listar.listarGastos();
    }
}


