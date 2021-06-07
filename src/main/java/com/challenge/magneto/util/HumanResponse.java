package com.challenge.magneto.util;

import java.util.Arrays;

public class HumanResponse {

	private String[] dna;

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	public HumanResponse() {}
	
	
	
	public HumanResponse(String[] dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "Human [dna=" + Arrays.toString(dna) + "]";
	}

}
