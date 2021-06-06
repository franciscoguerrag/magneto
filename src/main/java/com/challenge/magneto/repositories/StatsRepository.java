package com.challenge.magneto.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StatsRepository extends CrudRepository<Human, Long> {
}