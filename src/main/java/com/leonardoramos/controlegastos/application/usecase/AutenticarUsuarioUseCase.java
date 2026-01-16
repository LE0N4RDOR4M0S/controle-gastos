package com.leonardoramos.controlegastos.application.usecase;

import com.leonardoramos.controlegastos.application.dto.LoginDTO;
import com.leonardoramos.controlegastos.domain.model.Usuario;
import com.leonardoramos.controlegastos.domain.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public AutenticarUsuarioUseCase(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Usuario executar(LoginDTO dto) {
        Usuario usuario = repository.buscarPorEmail(dto.email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(dto.senha, usuario.getSenhaHash())) {
            throw new RuntimeException("Senha inválida");
        }

        return usuario;
    }
}

