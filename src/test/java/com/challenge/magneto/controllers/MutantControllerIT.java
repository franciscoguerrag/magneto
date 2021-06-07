package com.challenge.magneto.controllers;

import java.net.URI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.challenge.magneto.util.HumanResponse;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MutantControllerIT {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testMutantFounded() throws Exception {
		String[] t1 = { "ATGCAA", "BAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		testMutantOk(t1);
		String[] t2 = { "TTGCAA", "BAGTGC", "TTTTGT", "AGAAGG", "CCCCTA", "TCACTG" };
		testMutantOk(t2);
		String[] t3 = { "AAAAAA", "BAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		testMutantOk(t3);
	}

	@Test
	public void testMutantNotFounded() throws Exception {
		String[] t1 = { "GTGCAA", "BAGTGC", "TTATGT", "AGAAAG", "CCCCTA", "TCACTG" };
		testMutantForbidden(t1);
		String[] t2 = { "CTGCAA", "BCGTGC", "TTATGT", "AGAAAG", "CCCCTA", "TCACTG" };
		testMutantForbidden(t2);
		String[] t3 = { "TTGCAA", "TAGTGC", "TTATGT", "AGAAAG", "CCCCTA", "TCACTG" };
		testMutantForbidden(t3);
	}

	private void testMutantOk(String[] human) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/mutant/";
		URI uri = new URI(baseUrl);
		HumanResponse humanResponse = new HumanResponse(human);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<HumanResponse> request = new HttpEntity<>(humanResponse, headers);
		ResponseEntity<Object> result = restTemplate.postForEntity(uri, request, Object.class);
		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	private void testMutantForbidden(String[] human) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/mutant/";
		URI uri = new URI(baseUrl);
		HumanResponse humanResponse = new HumanResponse(human);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		HttpEntity<HumanResponse> request = new HttpEntity<>(humanResponse, headers);
		try {
			restTemplate.postForEntity(uri, request, Object.class);
			Assertions.fail();
		} catch (HttpClientErrorException ex) {
			// Verify bad request and missing header
			Assertions.assertEquals(403, ex.getRawStatusCode());
		}
	}

}
