package com.challenge.magneto.restservice;

import java.util.Arrays;

public class HumanEntity {
	
	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "Human [dna=" + Arrays.toString(dna) + "]";
	}
	
	
}
