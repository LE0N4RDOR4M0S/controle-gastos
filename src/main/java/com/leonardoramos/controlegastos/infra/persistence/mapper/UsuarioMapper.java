package com.leonardoramos.controlegastos.infra.persistence.mapper;

import com.leonardoramos.controlegastos.domain.model.Usuario;
import com.leonardoramos.controlegastos.infra.persistence.entity.UsuarioEntity;

public class UsuarioMapper {

    public static UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getSenhaHash(),
                usuario.getRoles()
        );
    }

    public static Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getEmail(),
                entity.getSenhaHash(),
                entity.getRoles()
        );
    }
}
