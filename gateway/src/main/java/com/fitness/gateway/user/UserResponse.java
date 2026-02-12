package com.fitness.gateway.user;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(
        Long user_id,
        String keycloakId,
        String email,
        String first_name,
        String last_name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}
