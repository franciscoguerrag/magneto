package com.challenge.magneto.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends CrudRepository<Human, Long> {
	
	@Query("select count(dna) from Human hm where hm.mutant is true")
    public int count_mutant_dna();
	
	@Query("select count(dna) from Human hm")
    public int count_human_dna();
}