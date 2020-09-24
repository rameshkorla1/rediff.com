package com.rediff.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MoneyWizPage {

	WebDriver driver;
	public MoneyWizPage(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	By rediffHomeLink = By.linkText("rediff.com");
	
	public WebElement Homelink() {
		
		return driver.findElement(rediffHomeLink);
	}
	
}
