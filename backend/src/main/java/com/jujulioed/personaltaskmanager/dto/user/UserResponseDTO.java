package com.jujulioed.personaltaskmanager.dto.user;

import java.time.LocalDate;

public record UserResponseDTO(
        String name,
        String email,
        boolean active,
        LocalDate registrationDate
) {
}
