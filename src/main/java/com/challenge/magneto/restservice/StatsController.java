package com.challenge.magneto.restservice;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.repositories.Human;
import com.challenge.magneto.repositories.HumanService;

import java.util.ArrayList;

@RestController

public class StatsController {

    @Autowired
    HumanService humanService;

    @GetMapping(path = "/stats")
    private String getUsuarios() {
    	return humanService.getStats().toString();
       
    }

    @GetMapping(path = "/")
    private String mainRoot() {
        return "Proyecto Magneto Bienvenidos";
    }
}