package com.epam.atm.webdriver.utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter{
	public static void waitForElement(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitForElementClickable(WebDriver driver, int timeout, String xpath) {
		new WebDriverWait(driver, timeout).pollingEvery(2, TimeUnit.SECONDS)
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
	}
	
	public static void waitForElementPresent(WebDriver driver, int timeout, String xpath) {
		new WebDriverWait(driver, timeout).pollingEvery(2, TimeUnit.SECONDS)
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}
}