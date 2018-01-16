package com.epa.atm.webdriver.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassengerInformation {
	
	@FindBy(xpath = "//label[@id='passengerMr_0']")
	private WebElement MR_RADIO_BUTTON;

	@FindBy(xpath = "//input[@id='name_0']")
	private WebElement ENTER_ADULT_FIRSTNAME;
	
	@FindBy(xpath = "//input[@id='surname1_0']")
	private WebElement ENTER_ADULT_LASTTNAME;
	
	@FindBy(xpath = "//input[@id='name_1']")
	private WebElement ENTER_CHILD_FIRSTNAME;
	
	@FindBy(xpath = "//input[@id='surname1_1']")
	private WebElement ENTER_CHILD_LASTTNAME;

	@FindBy(xpath = "//select[@id='ControlGroupPassengerContact_ContactInputPassengerContactView_DropDownListCountry']")
	private WebElement COUNTRY_DROPDOWN;
	
	@FindBy(xpath = "//select[@id='ControlGroupPassengerContact_ContactInputPassengerContactView_DropDownListCountry']/option[contains(text(),'India')]")
	private WebElement CHOOSE_COUNTRY;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement ENTER_PHONE_NUMBER;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement ENTER_EMAIL;
	
	@FindBy(xpath = "//input[@id='legal']/../ins")
	private WebElement ACCEPT_RADIO_BUTTON;
}
