package com.challenge.magneto.restservice;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.challenge.magneto.dao.Human;

public interface StatsService {
	
	public ArrayList<Human> getHumans();

	public JSONObject getStats();

}