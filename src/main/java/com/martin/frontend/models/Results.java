package com.martin.frontend.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

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
	 * @throws ParseException 
	 */
	public void convertTimestampsToEST() throws ParseException {
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
	 * @throws ParseException 
	 */
	private long convertToEST(long timestamp) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm aa");
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		
		return sdf.parse(sdf.format(new Date(timestamp))).getTime();
	}

}
