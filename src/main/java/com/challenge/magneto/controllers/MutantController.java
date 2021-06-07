package com.challenge.magneto.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.restservice.MutantService;
import com.challenge.magneto.util.HumanResponse;

@RestController
public class MutantController {

	@Autowired
	MutantService mutantService;

	@PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> checkMutant(@RequestBody HumanResponse human) {
		boolean isMutant = mutantService.isMutant(human.getDna());
		System.out.println("Arrays" + Arrays.toString(human.getDna()));
		if (isMutant)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}
}