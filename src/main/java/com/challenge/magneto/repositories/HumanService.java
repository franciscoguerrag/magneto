package com.challenge.magneto.repositories;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Service

public class HumanService {

    @Autowired
    HumanRepository humanRepository;

    public ArrayList<Human> getHumans() {
        return (ArrayList<Human>) humanRepository.findAll();
    }
    
    public void insertHuman(Human human) {
        humanRepository.save(human);
    }
    
    public JSONObject getStats() {
    	int count_mutant_dna=0;
    	int count_human_dna=0;
        count_mutant_dna=humanRepository.count_mutant_dna();
        count_human_dna=humanRepository.count_human_dna();
        double ratio = count_mutant_dna/(float)count_human_dna;
        DecimalFormat df = new DecimalFormat("##.##");
        JSONObject myObject = new JSONObject();
        // Cadenas de texto básicas
        myObject.put("count_human_dna", count_human_dna);
        myObject.put("count_mutant_dna", count_mutant_dna);
        myObject.put("ratio", df.format(ratio));
        
        return myObject;
    }

}