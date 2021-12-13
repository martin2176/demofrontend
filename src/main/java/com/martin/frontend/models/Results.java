package com.martin.frontend.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.martin.frontend.services.TimestampConverterService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

	private @JsonProperty("weather") Collection<Weather> weather;
	private @JsonProperty("main") Temperature temperature;
	private @JsonProperty("clouds") Clouds clouds;
	private @Getter(AccessLevel.NONE) long dt;
	private @JsonProperty("sys") System system;
	private @Getter(AccessLevel.NONE) String name;
	private @JsonProperty("wind") Wind windspeed;

	/*
	 * This overrides the 'name' key and sets it 'city'
	 */
	@JsonProperty("city")
	public String getCity() {
		return this.name;
	}

	/*
	 * Overrides the getter method of dt Converts the ts to EST date String
	 */
	@JsonProperty("dt")
	public String getDt() {
		return TimestampConverterService.convertToEst_Date(this.dt);
	}

}
