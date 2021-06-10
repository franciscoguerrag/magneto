package com.challenge.magneto.restservice;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.magneto.repositories.HumanRepository;

import java.text.DecimalFormat;

@Service

public class BasicStatsService implements StatsService {

	@Autowired
	HumanRepository humanRepository;

	public JSONArray getHumans() {
		return new JSONArray(humanRepository.findAll().toString());
	}

	public JSONObject getStats() {
		int count_mutant_dna = 0;
		int count_human_dna = 0;
		count_mutant_dna = humanRepository.count_mutant_dna();
		count_human_dna = humanRepository.count_human_dna();
		double ratio = count_human_dna!=0 ? (count_mutant_dna / (float) count_human_dna) : 0;
		DecimalFormat df = new DecimalFormat("##.##");
		JSONObject myObject = new JSONObject();
		// Cadenas de texto básicas
		myObject.put("count_human_dna", count_human_dna);
		myObject.put("count_mutant_dna", count_mutant_dna);
		myObject.put("ratio", df.format(ratio));

		return myObject;
	}

	@Override
	public void deleteAllHumans() {
		humanRepository.deleteAll();
	}

}