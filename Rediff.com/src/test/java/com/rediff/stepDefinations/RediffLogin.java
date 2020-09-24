package com.rediff.stepDefinations;

import com.rediff.pageObjects.HomePage;
import com.rediff.pageObjects.RediffMailPage;
import com.rediff.resources.base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RediffLogin extends base {

	HomePage hp;
	RediffMailPage rmp;

    @Given("^User is opens the browser and goes to \"([^\"]*)\"$")
    public void user_is_opens_the_browser_and_goes_to_something(String strArg1) throws Throwable {
       driver =initializeDriver();
       driver.get(strArg1);
    }
    @And("^User clicks on Rediffmail icon$")
    public void user_clicks_on_rediffmail_icon() throws Throwable {
    	hp = new HomePage(driver);
		hp.redifficon().click();
    }
    @When("^User enters invalid username (.+) and password (.+)$")
    public void user_enters_invalid_username_and_password(String username, String password) throws Throwable {
    	Thread.sleep(2000);
    	System.out.println("Inside When "+username);
    	rmp = new RediffMailPage(driver);
    	rmp.login().sendKeys(username);
		rmp.password().sendKeys(password);
		rmp.submit().click(); 
    }
    @Then("User sees the error message on the page")
    public void user_sees_the_error_message_on_the_page() throws InterruptedException {
    	Thread.sleep(2000);
    	rmp = new RediffMailPage(driver);
    	if(rmp.errormsg().getText().equalsIgnoreCase("Wrong username and password combination.")) {
	    	System.out.println("Test passed");
	    }else {
	    	System.out.println("Test failed");
	    }
    }   
    @And("^closes the browser$")
    public void closes_the_browser() throws Throwable {
    	driver.quit();
    	System.out.println("Closed");
    }
}
