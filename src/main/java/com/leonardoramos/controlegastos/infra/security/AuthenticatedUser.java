package com.leonardoramos.controlegastos.infra.security;

import java.util.Set;
import java.util.UUID;

public record AuthenticatedUser(
        UUID id,
        Set<String> role
) {
}
