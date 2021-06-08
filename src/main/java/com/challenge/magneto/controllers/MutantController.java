package com.challenge.magneto.controllers;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.dao.Human;
import com.challenge.magneto.restservice.MutantService;
import com.challenge.magneto.util.HumanResponse;

@RestController
public class MutantController {

	private static final Logger logger = LogManager.getLogger(MutantController.class);

	@Autowired
	MutantService mutantService;

	@PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> checkMutant(@RequestBody HumanResponse human) {
		logger.debug("checkMutant");
		try {
			boolean isMutant = mutantService.isMutant(human.getDna());
			mutantService.insertHuman(new Human(Arrays.toString(human.getDna()), isMutant));
			if (isMutant)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Oops! We have an Error. checkMutant" + e.getMessage());

		}
		return null;

	}
}