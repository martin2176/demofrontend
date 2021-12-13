package com.martin.frontend.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimestampConverterService {

	/**
	 * Converts the provided timestamp parameter to EST and returns a formated date
	 * String
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String convertToEst_Date(long timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(timestamp * 1000));

		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm aa");
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));

		return sdf.format(cal.getTime());
	}

	/**
	 * Converts the provided timestamp parameter to EST and returns a formated date
	 * String
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String convertToEst_Time(long timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(timestamp * 1000));

		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));

		return sdf.format(cal.getTime());
	}
}
