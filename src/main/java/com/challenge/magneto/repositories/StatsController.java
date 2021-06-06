package com.challenge.magneto.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class StatsController {

    @Autowired
    StatsService statsService;

    @GetMapping(path = "/stats")
    private ArrayList<Human> getUsuarios() {
        System.out.println("Buscando usuarios");
        return statsService.obtenerTodosUsuarios();
    }

    @GetMapping(path = "/")
    private String mainRoot() {
        return "Hello World Spring Boot - Google Cloud Platfom - Sql Cloud";
    }
}