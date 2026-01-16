package com.leonardoramos.controlegastos.security;

import com.leonardoramos.controlegastos.domain.valueobject.Role;
import com.leonardoramos.controlegastos.infra.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JwtAuthFilterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtService jwtService;

    @Test
    void request_with_valid_jwt_is_authenticated() throws Exception {

        UUID userId = UUID.randomUUID();

        String token = jwtService.gerarToken(
                userId,
                Set.of(Role.valueOf("ADMIN"))
        );

        mockMvc.perform(get("/gastos")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void request_with_invalid_jwt_is_rejected() throws Exception {

        mockMvc.perform(get("/gastos")
                        .header("Authorization", "Bearer token-invalido")
                )
                .andExpect(status().isUnauthorized());
    }
}
