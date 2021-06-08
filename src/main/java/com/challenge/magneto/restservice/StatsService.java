package com.challenge.magneto.restservice;

import org.json.JSONArray;
import org.json.JSONObject;

public interface StatsService {
	
	public JSONArray getHumans();
	
	public void deleteAllHumans();

	public JSONObject getStats();

}