package com.epa.atm.webdriver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VoloTeaHomePage {

	@FindBy(xpath = "//h2[@class='main-item' and contains(text(),'FLIGHTS')]")
	private WebElement HOME_PAGE;

	@FindBy(xpath = "//h2[@class='main-item' and contains(text(),'FLIGHTS')]")
	private WebElement FLIGHTS;
	
	@FindBy(xpath = "//h3[@class='title ' and contains(text(),'Search Flights')]")
	private WebElement SEARCH_FLIGHTS;
	
	
}
