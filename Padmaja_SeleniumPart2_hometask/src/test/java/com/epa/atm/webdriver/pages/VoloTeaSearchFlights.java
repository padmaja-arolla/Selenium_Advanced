package com.epa.atm.webdriver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VoloTeaSearchFlights {

	@FindBy(xpath = "//input[@value='Please choose departure airport' and @name='fromTyper']/../span")
	private WebElement DEPARTURE_FIELD;

	@FindBy(xpath = "//input[@value='Please choose departure airport' and @name='fromTyper']")
	private WebElement ENTER_DEPARTURE_AIRPORT;
	
	@FindBy(xpath = "//a[contains(text(),'\"+departureCity+\"')]")
	private WebElement SELECTED_DEPARTURE_AIRPORT;
	
	@FindBy(xpath = "//input[@value='Please choose departure airport' and @name='fromTyper']/../span")
	private WebElement ACTUAL_DEPARTURE_AIRPORT;

	@FindBy(xpath = "//input[@value='Please choose destination airport' and @name='toTyper']")
	private WebElement ENTER_DESTINATION_AIRPORT;
	
	@FindBy(xpath = "//a[contains(text(),'\"+destinationCity+\"')]")
	private WebElement SELECTED_DESTINATION_AIRPORT;
	
	@FindBy(xpath = "//input[@value='Please choose destination airport' and @name='toTyper']/../span")
	private WebElement ACTUAL_DESTINATION_AIRPORT;
	
	@FindBy (xpath = "//a[@class='ui-state-default ui-state-active']")
	private WebElement SELECT_DEPARTURE_DATE;
	
	@FindBy (xpath = "//span[@id='spandeparturedate']")
	private WebElement DEPARTURE_DATE_VALUE;
	
	@FindBy (xpath = "//a[@class='ui-state-default ui-state-active']")
	private WebElement SELECT_RETURN_DATE;
	
	@FindBy (xpath = "//span[@id='spanreturnedate']")
	private WebElement RETURN_DATE_VALUE;
	
	@FindBy (xpath = "//select[@name='children']")
	private WebElement CHILDREN_DROPDOWN;
	//select[@name='children']
	
	@FindBy (xpath = "//select[@name='children']/optgroup/option[2]")
	private WebElement SELECT_NUMBER_OF_CHILDERN;
	
	@FindBy (xpath = "//select[@name='children']/../span")
	private WebElement SELECTED_NUMBER_OF_CHILDERN;
	
	@FindBy (xpath = "//a[contains(text(),'FIND FLIGHTS')]")
	private WebElement FIND_FLIGHTS_BUTTON;
}
