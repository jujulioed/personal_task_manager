package com.jujulioed.personaltaskmanager.services;

import com.jujulioed.personaltaskmanager.dto.user.UserResponseDTO;
import com.jujulioed.personaltaskmanager.entity.User;
import com.jujulioed.personaltaskmanager.repositories.UserRepository;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

// @ExtendWith(MockitoExtension.class): Integra o Mockito com o JUnit 5.
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // @Mock: Cria uma implementação simulada do repository.
    @Mock
    private UserRepository userRepository;

    // @InjectMocks: Instancia o service e injeta as dependências simuladas.
    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserWhenIdExists() {
        // Arrange
        User user = new User(
                1L,
                "Julio",
                "Julio@gmail.com",
                "passw",
                true,
                LocalDate.of(2020, 1, 8)
        );

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        // Act
        Optional<UserResponseDTO> result = userService.findUserById(1L);

        // Assert
        assertTrue(result.isPresent());

        UserResponseDTO response = result.get();

        assertEquals(user.getName(), response.name());
        assertEquals(user.getEmail(), response.email());
        assertEquals(user.isActive(), response.active());
        assertEquals(user.getRegistrationData(), response.registrationData());

        verify(userRepository).findById(1L);
    }

}
