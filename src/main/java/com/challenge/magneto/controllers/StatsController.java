package com.challenge.magneto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.restservice.StatsService;

@RestController

public class StatsController {

	@Autowired
	StatsService statsService;

	@GetMapping(path = "/stats")
	private String getStats() {
		return statsService.getStats().toString();

	}

	@GetMapping(path = "/humans")
	private String getHumans() {
		return statsService.getHumans().toString();

	}

	@GetMapping(path = "/")
	private String mainRoot() {
		return "{\"Proyecto Magneto\":\" Bienvenidos\"}";
	}
}