package com.challenge.magneto.dao;

import javax.persistence.*;

@Entity
public class Human {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	private String dna;

	private boolean mutant;

	public Human() {
	}

	public Human(String dna, boolean mutant) {
		super();
		this.dna = dna;
		this.mutant = mutant;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "{id:" + id + ";dna:" + dna + ";isMutant:" + mutant + "}";
	}

}