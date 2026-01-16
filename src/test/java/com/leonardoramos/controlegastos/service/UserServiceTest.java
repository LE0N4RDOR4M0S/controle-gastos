package com.leonardoramos.controlegastos.service;

import com.leonardoramos.controlegastos.application.dto.RegistroDTO;
import com.leonardoramos.controlegastos.application.usecase.RegistrarUsuarioUseCase;
import com.leonardoramos.controlegastos.domain.model.Usuario;
import com.leonardoramos.controlegastos.domain.valueobject.Role;
import com.leonardoramos.controlegastos.infra.security.AuthenticatedUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private RegistrarUsuarioUseCase userService;

    @AfterEach
    void cleanup() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void admin_can_create_admin_user() {

        var principal = new AuthenticatedUser(
                UUID.randomUUID(),
                Set.of("ADMIN")
        );

        var auth = new UsernamePasswordAuthenticationToken(
                principal,
                null,
                Set.of(() -> "ROLE_ADMIN")
        );

        SecurityContextHolder.getContext()
                .setAuthentication(auth);

        RegistroDTO request =
                new RegistroDTO("admin2@x.com", "123", "ADMIN");

        Usuario user = userService.executar(request);

        assertEquals(Role.ADMIN, user.getRoles());
    }
}
