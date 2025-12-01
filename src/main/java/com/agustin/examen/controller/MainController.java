package com.agustin.examen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    // Methods
    // Endpoint Get /

    @GetMapping("/")
    public String index() {
        return "API REST con Spring Boot.";
    }
}