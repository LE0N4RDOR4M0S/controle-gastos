package com.leonardoramos.controlegastos.application.usecase;

import com.leonardoramos.controlegastos.application.dto.RegistroDTO;
import com.leonardoramos.controlegastos.domain.model.Usuario;
import com.leonardoramos.controlegastos.domain.repository.UsuarioRepository;
import com.leonardoramos.controlegastos.domain.valueobject.Role;
import com.leonardoramos.controlegastos.infra.persistence.entity.UsuarioEntity;
import com.leonardoramos.controlegastos.infra.persistence.mapper.UsuarioMapper;
import com.leonardoramos.controlegastos.infra.security.SecurityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RegistrarUsuarioUseCase {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public RegistrarUsuarioUseCase(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public Usuario executar(RegistroDTO dto) {
        var authUser = SecurityUtils.getAuthenticatedUser();
        Role roleToAssign;
        if (authUser == null) {
            roleToAssign = Role.ADMIN;
        } else if ("ADMIN".equals(authUser.role())) {
            roleToAssign = dto.role != null
                    ? Role.valueOf(dto.role)
                    : Role.USER;
        } else {
            throw new RuntimeException("Usuário não autorizado a criar usuários");
        }
        String senhaHash = encoder.encode(dto.senha);
        Usuario novoUsuario = new Usuario(
                UUID.randomUUID(),
                dto.email,
                senhaHash,
                Set.of(roleToAssign)
        );
        //TODO: validar se email já existe
        repository.salvar(novoUsuario);
        return novoUsuario;
    }
}

