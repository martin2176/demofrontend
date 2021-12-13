package com.martin.frontend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {

	private @JsonProperty("feels_like") long feelsLike;
	private @JsonProperty("temp_min") long min;
	private @JsonProperty("temp_max") long max;
	private @JsonProperty("pressure") long pressure;
	private @JsonProperty("humidity") long humidity;
	private long temp;

}
