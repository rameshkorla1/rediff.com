package com.rediff.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgotYourPassword {
    WebDriver driver;
	public ForgotYourPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	By fypText = By.cssSelector("div.padt15.ralignC.rbold.f16");
	
	
	public WebElement fypTextheader() {
		return driver.findElement(fypText);
	}
}
