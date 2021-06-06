package com.challenge.magneto.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.magneto.util.SearchMutant;

@RestController
public class MutantController {

	@PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
	public void addMember(@RequestBody HumanEntity human) {
		
		SearchMutant searchMutant =new SearchMutant();
		searchMutant.itdentifyMutant(human.getDna());
		
	}
}