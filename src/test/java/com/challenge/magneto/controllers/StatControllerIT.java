package com.challenge.magneto.controllers;

import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StatControllerIT {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testStatsResponse() throws Exception {
		testStats();

	}

	private void testStats() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/stats/";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
		System.out.println("result"+ result);
		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
		Assertions.assertTrue(result.getBody().toString().contains("count_human_dna"));
		Assertions.assertTrue(result.getBody().toString().contains("count_mutant_dna"));
		Assertions.assertTrue(result.getBody().toString().contains("ratio"));
	}
	
	@Test
	public void testHumansResponse() throws Exception {
		testHumans();
	}

	private void testHumans() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/humans/";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
		System.out.println("result"+ result);
		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testWelcome() throws Exception {
		testUrlBlank();
	}

	private void testUrlBlank() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
		System.out.println("result"+ result);
		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

}
