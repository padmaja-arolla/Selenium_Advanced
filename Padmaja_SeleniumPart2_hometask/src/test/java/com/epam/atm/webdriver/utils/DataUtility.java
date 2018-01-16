package com.epam.atm.webdriver.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.epam.atm.webdriver.utils.DataUtility;

public class DataUtility{
	
	private static DataUtility constants = null;
	private static final String START_URL = "http://www.volotea.com/en";
	

	private static final String EXPECTED_HOMEPAGE_TEXT = "FLIGHTS";
	private static final String DEPARTURE_CITY = "Munich";
	private static final String EXPECTED_DEPARTURE_AIRPORT = "Munich · MUC";
	private static final String DESTINATION_CITY = "Mykonos";
	private static final String EXPECTED_DESTINATION_AIRPORT = "Mykonos · JMK";
	private static final String EXPECTED_PASSENGERS_COUNT = "(2 passengers)";
	private static final String EXPECTED_AIRPORT_SLECTION = "Munich · Mykonos";
	private static final String SEARCH_PAGE_VALIDATION = "Your search";
	private static final String ADUlT_FIRSTNAME = "Padmaja";
	private static final String ADUlT_LASTNAME = "Reddy";
	private static final String CHILD_FIRSTNAME = "Aanya";
	private static final String CHILD_LASTTNAME = "Reddy";
	private static final String PHONE_NUMBER = "9922002200";
	private static final String USER_EMAIL = "padmaja@volotea.com";
	

	public static synchronized DataUtility getInstance() {
		if (constants == null) {
			constants = new DataUtility();
		}
		return constants;
	}
	
	public String SelectedDateFormatter(String selectedDate) {
	    Date date = null;
	    String dateString = null;
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
		try { 	date = formatter.parse(selectedDate);
	    		SimpleDateFormat formatter1 = new SimpleDateFormat("E dd MMM yyyy");
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	    SimpleDateFormat sdfr = new SimpleDateFormat("E dd MMM yyyy");
	    try{
	 	dateString = sdfr.format( date );
	    }catch (Exception ex ){
	 	System.out.println(ex);
	    }
	    return dateString;
		}
	
	public String ActualDateFormatter(String actualDate) {
	    Date date = null;
	    String dateString = null;
		SimpleDateFormat formatter = new SimpleDateFormat("E dd MMM yyyy");
		try { 	date = formatter.parse(actualDate);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	    SimpleDateFormat sdfr = new SimpleDateFormat("E dd MMM yyyy");
	    try{
	 	dateString = sdfr.format( date );
	    }catch (Exception ex ){
	 	System.out.println(ex);
	    }
	    return dateString;
		}
	
	public static String getStartUrl() {
		return START_URL;
	}

	public static String getExpectedHomepageText() {
		return EXPECTED_HOMEPAGE_TEXT;
	}

	public static String getDepartureCity() {
		return DEPARTURE_CITY;
	}

	public static String getExpectedDepartureAirport() {
		return EXPECTED_DEPARTURE_AIRPORT;
	}
	public static String getDestinationCity() {
		return DESTINATION_CITY;
	}

	public static String getExpectedDestinationAirport() {
		return EXPECTED_DESTINATION_AIRPORT;
	}

	public static String getExpectedPassengersCount() {
		return EXPECTED_PASSENGERS_COUNT;
	}

	public static String getExpectedAirportSlection() {
		return EXPECTED_AIRPORT_SLECTION;
	}

	public static String getSearchPageValidation() {
		return SEARCH_PAGE_VALIDATION;
	}

	public static String getAdultFirstname() {
		return ADUlT_FIRSTNAME;
	}

	public static String getAdultLastname() {
		return ADUlT_LASTNAME;
	}

	public static String getChildFirstname() {
		return CHILD_FIRSTNAME;
	}

	public static String getChildLasttname() {
		return CHILD_LASTTNAME;
	}
	public static String getPhoneNumber() {
		return PHONE_NUMBER;
	}

	public static String getUserEmail() {
		return USER_EMAIL;
	}
}