package com.challenge.magneto.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.restservice.StatsService;

@RestController

public class StatsController {

	private static final Logger logger = LogManager.getLogger(StatsController.class);

	@Autowired
	StatsService statsService;

	@GetMapping(path = "/stats")
	private String getStats() {
		logger.debug("checkStats");
		try {
			return statsService.getStats().toString();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Oops! We have an Error." + e.getMessage());
		}
		return null;
	}

	@GetMapping(path = "/humans")
	private String getHumans() {
		logger.debug("getHumans");
		try {
			return statsService.getHumans().toString();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Oops! We have an Error." + e.getMessage());
		}
		return null;

	}

	@GetMapping(path = "/")
	private String mainRoot() {
		logger.debug("Proyecto Magneto");
		return "{\"Proyecto Magneto\":\" Bienvenidos\"}";
	}
}