package com.martin.frontend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.martin.frontend.services.TimestampConverterService;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class System {

	private String country;
	private @Getter(AccessLevel.NONE) long sunrise;
	private @Getter(AccessLevel.NONE) long sunset;

	@JsonProperty("sunrise")
	public String getSunrise() {
		return TimestampConverterService.convertToEst_Date(this.sunrise);
	}

	@JsonProperty("sunset")
	public String getSunset() {
		return TimestampConverterService.convertToEst_Date(this.sunset);
	}

}