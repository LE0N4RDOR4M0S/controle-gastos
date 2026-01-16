package com.leonardoramos.controlegastos.infra.api;

import com.leonardoramos.controlegastos.application.dto.*;
import com.leonardoramos.controlegastos.application.usecase.AutenticarUsuarioUseCase;
import com.leonardoramos.controlegastos.application.usecase.RegistrarUsuarioUseCase;
import com.leonardoramos.controlegastos.domain.model.Usuario;
import com.leonardoramos.controlegastos.infra.security.JwtService;
import com.leonardoramos.controlegastos.infra.security.RefreshTokenService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final RegistrarUsuarioUseCase registrar;
    private final AutenticarUsuarioUseCase autenticar;
    private final JwtService jwt;
    private final RefreshTokenService refreshTokenService;

    public AuthController(
            RegistrarUsuarioUseCase registrar,
            AutenticarUsuarioUseCase autenticar,
            JwtService jwt,
            RefreshTokenService refreshTokenService
    ) {
        this.registrar = registrar;
        this.autenticar = autenticar;
        this.jwt = jwt;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/register")
    public UsuarioResponseDTO registrar(@RequestBody RegistroDTO dto) {
        Usuario u = registrar.executar(dto);
        //TODO: adicionar roles ao token
        String token = jwt.gerarToken(u.getId(), null);

        UsuarioResponseDTO res = new UsuarioResponseDTO();
        res.id = u.getId();
        res.email = u.getEmail();
        res.token = token;
        return res;
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginDTO dto) {
        Usuario u = autenticar.executar(dto);
    //TODO: adicionar roles ao token
        String accessToken = jwt.gerarToken(u.getId(), null);
        UUID refreshToken = refreshTokenService.criar(u.getId()).getId();

        return new TokenResponse(accessToken, refreshToken);
    }

    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestBody RefreshDTO dto) {
        UUID userId = refreshTokenService.validar(dto.getRefreshToken());
        //TODO: adicionar roles ao token
        String accessToken = jwt.gerarToken(userId, null);
        return new TokenResponse(accessToken, dto.getRefreshToken());
    }

}

