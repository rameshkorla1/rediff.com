package com.rediff.stepDefinations;

import com.rediff.pageObjects.ForgotYourPassword;
import com.rediff.pageObjects.HomePage;
import com.rediff.pageObjects.RediffMailPage;
import com.rediff.resources.base;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPassword extends base {
	HomePage hp;
	RediffMailPage rmp;
	ForgotYourPassword fyp;
	@Given("^User is on Rediff Landing Page$")
    public void user_is_on_rediff_landing_page() throws Throwable {
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
    }
	@And("^User Clicks on Sign in Link$")
    public void user_clicks_on_sign_in_link() throws Throwable {
		hp = new HomePage(driver);
		hp.signin().click(); 
	}
    @When("^User clicks on the Fogort Password Link$")
    public void user_clicks_on_the_fogort_password_link() throws Throwable {
        rmp = new RediffMailPage(driver);
        rmp.forgotlink().click();
    }

    @Then("^Forgot Passowrd page opens$")
    public void forgot_passowrd_page_opens() throws Throwable {
    	fyp = new ForgotYourPassword(driver);
        String abc = fyp.fypTextheader().getText();
        if(abc.equalsIgnoreCase("Forgot your password?")) {
     	   System.out.println("Pass");
        }else {
     	   System.out.println("Fail");
        }
        //
        driver.quit();
    }

}
