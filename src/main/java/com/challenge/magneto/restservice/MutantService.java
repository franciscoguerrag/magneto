package com.challenge.magneto.restservice;

import org.springframework.stereotype.Service;

import com.challenge.magneto.dao.Human;

public interface MutantService {

	public void insertHuman(Human human);
	
	public boolean isMutant(String[] dna);

}