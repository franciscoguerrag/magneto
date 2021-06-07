package com.challenge.magneto.restservice;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.challenge.magneto.dao.Human;

public interface StatsService {
	
	public JSONArray getHumans();

	public JSONObject getStats();

}