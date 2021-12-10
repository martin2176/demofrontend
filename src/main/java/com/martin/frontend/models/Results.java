package com.martin.frontend.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private @JsonProperty("dt") long time;
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

	/**
	 * Converts All of the timestamps to EST
	 */
	public void convertTimestampsToEST() {
		this.time = convertToEST(this.time);
		this.system.setSunrise(convertToEST(this.system.getSunrise()));
		this.system.setSunset(convertToEST(this.system.getSunset()));
	}

	/**
	 * Converts the provided timestamp parameter to EST and returns the long
	 * timestamp value
	 * 
	 * @param timestamp
	 * @return
	 */
	private long convertToEST(long timestamp) {
		LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("US/Eastern"));

		return localDateTime.toInstant(ZoneOffset.ofHours(0)).toEpochMilli();
	}

}
