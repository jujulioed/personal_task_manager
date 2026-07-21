package com.jujulioed.personaltaskmanager.controllers;


import com.jujulioed.personaltaskmanager.dto.user.UserResponseDTO;
import com.jujulioed.personaltaskmanager.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDTO>> getUser(@PathVariable("id") Long id) {
        logger.info("Accessed /api/users/id endpoint");
        Optional<UserResponseDTO> response = userService.findUserById(id);
        return ResponseEntity.ok(response);
    }
}
