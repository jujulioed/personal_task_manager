package com.jujulioed.personaltaskmanager.services;

import com.jujulioed.personaltaskmanager.dto.user.UserResponseDTO;
import com.jujulioed.personaltaskmanager.entity.User;
import com.jujulioed.personaltaskmanager.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserResponseDTO> findUserById(Long id) {
        Optional<User> foundUser = this.userRepository.findById(id);

        Optional<UserResponseDTO> response = Optional.of(new UserResponseDTO(
                foundUser.get().getName(),
                foundUser.get().getEmail(),
                foundUser.get().isActive(),
                foundUser.get().getRegistrationData()));
        return response;
    }
}
