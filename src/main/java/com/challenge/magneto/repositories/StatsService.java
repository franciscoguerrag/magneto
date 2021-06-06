package com.challenge.magneto.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class StatsService {

    @Autowired
    StatsRepository statsRepository;

    public ArrayList<Human> obtenerTodosUsuarios() {
        return (ArrayList<Human>) statsRepository.findAll();
    }

}