package com.challenge.magneto.restservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.repositories.Human;
import com.challenge.magneto.repositories.HumanEntity;
import com.challenge.magneto.repositories.HumanService;
import com.challenge.magneto.util.SearchMutant;

@RestController
public class MutantController {

	@Autowired
	HumanService humanService;

	@PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?>  addMember(@RequestBody HumanEntity human) {
		SearchMutant searchMutant =new SearchMutant();
		boolean isMutant = searchMutant.isMutant(human.getDna());
		System.out.println(Arrays.toString(human.getDna()));
		humanService.insertHuman(new Human(Arrays.toString(human.getDna()),isMutant));
		if (isMutant)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<Error>(HttpStatus.FORBIDDEN);
		
	}
}