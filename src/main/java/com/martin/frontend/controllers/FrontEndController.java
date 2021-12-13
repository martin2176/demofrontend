package com.martin.frontend.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martin.frontend.models.Results;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FrontEndController {

	@Value("${weather.api.uri}")
	String uri;

	RestTemplate restTemplate;

	public FrontEndController() {
		this.restTemplate = new RestTemplate();
	}

	/**
	 * Makes call to backend RestService to get Weather Information Maps results to
	 * Result object (parses out only required information Returns the output of
	 * mapping the Result object to a JSON String object
	 * 
	 * @return
	 */
	@GetMapping("weather")
	public String getWeather() {
		ObjectMapper mapper = new ObjectMapper();

		Results result = restTemplate.getForObject(uri, Results.class);

		String jsonResults = null;

		/*
		 * Will attempt to parse the Results object to JSON String object If an error
		 * occurs, it will log the error message, print the stack trace in console, and
		 * return an error message.
		 */
		try {
			jsonResults = mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			log.error("Error Parsing Results: ", e.getMessage());
			e.printStackTrace();
			return "Error Parsing Results: " + e.getMessage();
		}

		log.info("Backend API response - {}", jsonResults);
		return jsonResults;
	}

}
