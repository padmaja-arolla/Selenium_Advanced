package com.epa.atm.webdriver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults {
	
	@FindBy(xpath = "//h2[contains(text(),'Your search')]/../span")
	private WebElement PASSENGERS_COUNT;

	@FindBy(xpath = "//div[@class='departure']/p/strong[@class='date']")
	private WebElement ACTUAL_DEPARTURE_DATE;
	
	@FindBy(xpath = "//div[@class='return']/p/strong[@class='date']")
	private WebElement ACTUAL_RETURN_DATE;
	
	@FindBy(xpath = "//strong[contains(text(),'Munich · Mykonos')]")
	private WebElement AIRPORTS_SELECTED;
	
	@FindBy(xpath = "//h2[contains(text(),'Your search')]")
	private WebElement SEARCH_RESULTS_PAGE;

	@FindBy(xpath = "//a[contains(text(),' NEXT STEP')]")
	private WebElement NEXT_STEP_BUTTON;
	
	@FindBy(xpath = "//a[@class='close']")
	private WebElement POPUP_CLOSE_BUTTON;
}
