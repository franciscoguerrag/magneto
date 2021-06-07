package com.challenge.magneto.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.magneto.dao.Human;
import com.challenge.magneto.repositories.HumanRepository;
import com.challenge.magneto.util.SearchMutant;

@Service
public class BasicMutantService implements MutantService {

	@Autowired
	HumanRepository humanRepository;

	public void insertHuman(Human human) {
		//humanRepository.save(human);
	}

	@Override
	public boolean isMutant(String[] dna) {
		SearchMutant searchMutant = new SearchMutant();
		return searchMutant.isMutant(dna);
	}

}