package com.rediff.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RediffMailPage {

	WebDriver driver;
	public RediffMailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	By loginName = By.name("login");
	By password = By.name("passwd");
	By submit = By.name("proceed");
	By redifflink = By.linkText("rediff.com");
	By errormsg = By.cssSelector("div[id='div_login_error'] b");
	By forgotPassLink = By.cssSelector("a[href*='newforgot']");
	
	public WebElement login() {
		return driver.findElement(loginName);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
	return driver.findElement(submit);	
		
	}
	
	public WebElement forgotlink() {
		return driver.findElement(forgotPassLink);
	}
	
	public WebElement errormsg() {
		return driver.findElement(errormsg);
	}
	
	public WebElement BackToHome() {
		return driver.findElement(redifflink);
	}
}
