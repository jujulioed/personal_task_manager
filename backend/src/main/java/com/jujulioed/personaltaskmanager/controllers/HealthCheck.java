package com.jujulioed.personaltaskmanager.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HealthCheck {

    @GetMapping
    public ResponseEntity<String> CheckApi() {
        return ResponseEntity.ok("API Online!");
    }
}
