package com.leonardoramos.controlegastos.infra.persistence.adapter;

import com.leonardoramos.controlegastos.domain.model.Usuario;
import com.leonardoramos.controlegastos.domain.repository.UsuarioRepository;
import com.leonardoramos.controlegastos.infra.persistence.entity.UsuarioEntity;
import com.leonardoramos.controlegastos.infra.persistence.mapper.UsuarioMapper;
import com.leonardoramos.controlegastos.infra.persistence.repository.JpaUsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUsuarioRepositoryAdapter implements UsuarioRepository {

    private final JpaUsuarioRepository jpa;

    public JpaUsuarioRepositoryAdapter(JpaUsuarioRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void salvar(Usuario usuario) {
        jpa.save(UsuarioMapper.toEntity(usuario));
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return jpa.findByEmail(email)
                .map(e -> UsuarioMapper.toDomain(e));
    }
}

