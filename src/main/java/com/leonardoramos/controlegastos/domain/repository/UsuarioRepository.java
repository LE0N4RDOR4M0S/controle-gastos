package com.leonardoramos.controlegastos.domain.repository;

import com.leonardoramos.controlegastos.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {

    void salvar(Usuario usuario);

    Optional<Usuario> buscarPorEmail(String email);
}

