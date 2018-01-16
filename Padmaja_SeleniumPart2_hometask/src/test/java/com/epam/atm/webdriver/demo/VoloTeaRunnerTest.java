package com.epam.atm.webdriver.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.atm.webdriver.utils.Waiter;
import com.epam.atm.webdriver.utils.DataUtility;

public class VoloTeaRunnerTest {
	public static WebDriver driver;
	public static String fDepartureDate, fReturnDate, fActualDepartureDate, fActualReturnDate;
	DataUtility dataUtility; 
	
	@BeforeTest
	public static void setup(){
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	driver = new ChromeDriver();
	System.out.println("Initialized the driver");
	}
	
	@AfterTest
	public static void tearDown() {
		System.out.println("Closing the driver");
		driver.quit();
	}
	@Test
	public void Open(){
		driver.get(DataUtility.getStartUrl());
		System.out.println("In Open");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String HomePageText=driver.findElement(By.xpath("//h2[@class='main-item' and contains(text(),'FLIGHTS')]")).getText();
		System.out.println(HomePageText);
		Assert.assertEquals(DataUtility.getExpectedHomepageText(), HomePageText, "HomePage not opened Successfully");	
	}
	
	@Test
	public void departureField() throws InterruptedException{
		System.out.println("In departureField");
		driver.findElement(By.xpath("//h2[@class='main-item' and contains(text(),'FLIGHTS')]")).click();
		driver.findElement(By.xpath("//h3[@class='title ' and contains(text(),'Search Flights')]")).click();
		WebElement departure = driver.findElement(By.xpath("//input[@value='Please choose departure airport' and @name='fromTyper']/../span"));
		departure.click();
		WebElement departureAirport = driver.findElement(By.xpath("//input[@value='Please choose departure airport' and @name='fromTyper']"));
		Thread.sleep(5000);
		departureAirport.sendKeys(DataUtility.getDepartureCity());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'"+DataUtility.getDepartureCity()+"')]")).click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actualDepartureAirport= driver.findElement(By.xpath("//input[@value='Please choose departure airport' and @name='fromTyper']/../span")).getText();
		System.out.println(actualDepartureAirport);
		Assert.assertEquals(DataUtility.getExpectedDepartureAirport(), actualDepartureAirport,"Aiport selected is different");	
	}
	
		@Test (priority=1)
	public void destinationField() throws InterruptedException{
			System.out.println("In destinationField");
			WebElement destinationAirport = driver.findElement(By.xpath("//input[@value='Please choose destination airport' and @name='toTyper']"));
			Thread.sleep(5000);
			destinationAirport.sendKeys(DataUtility.getDestinationCity());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'"+DataUtility.getDestinationCity()+"')]")).click();
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String actualDestinationAirport= driver.findElement(By.xpath("//input[@value='Please choose destination airport' and @name='toTyper']/../span")).getText();
			System.out.println(actualDestinationAirport);
			Assert.assertEquals(DataUtility.getExpectedDestinationAirport(), actualDestinationAirport,"Aiport selected is different");	
	}
		
	@Test (priority=2)
	public void selectDepartureDate() throws InterruptedException{
		System.out.println("In selectDepartureDate");
		//driver.findElement(By.xpath("//div[@id='search-departure-date']")).click();
		Waiter.waitForElementClickable(driver, 6, "//a[@class='ui-state-default ui-state-active']");
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
		Thread.sleep(5000);
		String departureDate = driver.findElement(By.xpath("//span[@id='spandeparturedate']")).getText();
		fDepartureDate = dataUtility.SelectedDateFormatter(departureDate);
	}
	
	@Test (priority=3)
	public void selectReturnDate() throws InterruptedException{
		System.out.println("In selectReturnDate");
			Waiter.waitForElementClickable(driver, 4, "//a[@class='ui-state-default ui-state-active']");
			driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
			Thread.sleep(5000);
			String returnDate = driver.findElement(By.xpath("//span[@id='spanreturndate']")).getText();
			fReturnDate = dataUtility.SelectedDateFormatter(returnDate);
	}

	@Test (priority=4)
	public void selectPassengers() throws InterruptedException{
		System.out.println("In selectPassengers");
		driver.findElement(By.xpath("//select[@name='children']")).click();
		driver.findElement(By.xpath("//select[@name='children']/optgroup/option[2]")).click();
		String passengerCount;
		passengerCount=driver.findElement(By.xpath("//select[@name='children']/../span")).getText();
		System.out.println(passengerCount);
		
	}
	
	@Test (priority=5)
	public void performSearch() {
		driver.findElement(By.xpath("//a[contains(text(),'FIND FLIGHTS')]")).click();
	}
	
	@Test (priority=6)
	public void verifyPassengers(){
		System.out.println("In verifyPassengers");
		 String passengerCount=driver.findElement(By.xpath("//h2[contains(text(),'Your search')]/../span")).getText();
		System.out.println(passengerCount);
		Assert.assertEquals(DataUtility.getExpectedPassengersCount(), passengerCount,"Selected passengers count is wrong");		
	}
	
	@Test (priority=7)
	public void verifyDepartureDate(){
		System.out.println("In verifyDepartureDate");
		String actualDepartureDate = driver.findElement(By.xpath("//div[@class='departure']/p/strong[@class='date']")).getText();
		fActualDepartureDate = dataUtility.ActualDateFormatter(actualDepartureDate);
		Assert.assertEquals(fDepartureDate,fActualDepartureDate,"Departure date is different from the selected.");
		
	}
	
	@Test (priority=8)
	public void verifyReturnDate(){
		System.out.println("In verifyReturnDate");
		String actualReturnDate = driver.findElement(By.xpath("//div[@class='return']/p/strong[@class='date']")).getText();		
		fActualReturnDate = dataUtility.ActualDateFormatter(actualReturnDate);
		Assert.assertEquals(fReturnDate,fActualReturnDate,"Return date is different from the selected.");
	}
		
	@Test (priority=9)
	public void verifyAirports(){
		System.out.println("In verifyAirports");
		String airports = driver.findElement(By.xpath("//strong[contains(text(),'Munich · Mykonos')]")).getText();
		Assert.assertEquals(DataUtility.getExpectedAirportSlection(), airports, "Results are not displayed for the selected airports");
	}
	
	@Test (priority=10)
	public void verifySearch() {
		String searchPageHeading;
		searchPageHeading = driver.findElement(By.xpath("//h2[contains(text(),'Your search')]")).getText();
		Assert.assertEquals(DataUtility.getSearchPageValidation(),searchPageHeading, "Search results are displayed");
	} 
	@Test (priority=11)
	public void passengerInformation() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),' NEXT STEP')]")).click();
		System.out.println("Entering passenger details");
		
		Thread.sleep(5000);		
		WebElement element = driver.findElement(By.xpath("//a[@class='close']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//a[contains(text(),' NEXT STEP')]")).click();
		
		//driver.findElement(By.xpath("//a[@class='close']/..")).click();
		driver.findElement(By.xpath("//label[@id='passengerMr_0']")).click();
		WebElement AdultFirstName = driver.findElement(By.xpath("//input[@id='name_0']"));
		AdultFirstName.sendKeys(DataUtility.getAdultFirstname());
		WebElement AdultLastName = driver.findElement(By.xpath("//input[@id='surname1_0']"));
		AdultLastName.sendKeys(DataUtility.getAdultLastname());
		WebElement ChildFirstName = driver.findElement(By.xpath("//input[@id='name_1']"));
		ChildFirstName.sendKeys(DataUtility.getChildFirstname());
		WebElement ChildLastName = driver.findElement(By.xpath("//input[@id='surname1_1']"));
		ChildLastName.sendKeys(DataUtility.getChildLasttname());
		System.out.println("Entering contact infromation");
		WebElement CountryResidence = driver.findElement(By.xpath("//select[@id='ControlGroupPassengerContact_ContactInputPassengerContactView_DropDownListCountry']"));
		CountryResidence.click();
		driver.findElement(By.xpath("//select[@id='ControlGroupPassengerContact_ContactInputPassengerContactView_DropDownListCountry']/option[contains(text(),'India')]")).click();
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(DataUtility.getPhoneNumber());
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(DataUtility.getUserEmail());
		driver.findElement(By.xpath("//input[@id='legal']/../ins")).click();
	}
}
