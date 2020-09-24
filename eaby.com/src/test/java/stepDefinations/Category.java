package stepDefinations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Categories;


public class Category extends DriverManager {
	
	Categories ct;
	WebDriverWait wait;
	@Given("User is a non-registered customer and navigate to ebay site")
    public void user_is_a_nonregistered_customer_and_navigate_to_wwwebaycouk() throws Throwable {
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @When("^User enter a search term and select a specific Category$")
    public void user_enter_a_search_term_and_select_a_specific_category() throws Throwable {
    	ct = new Categories(driver);
        ct.SearchTextbox().click();
        ct.SearchTextbox().sendKeys("mobile phones");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ct.SearchTextbox()));
        ct.SearchTextbox().sendKeys(Keys.DOWN);
        ct.SearchTextbox().sendKeys(Keys.ENTER);
    }

    @Then("^User get a list of matching results$")
    public void user_get_a_list_of_matching_results() throws Throwable {
    	ct = new Categories(driver);
        ct.SortingProductList();
    }

    @And("^User can verify that the results shown as per the the selected category$")
    public void user_can_verify_that_the_results_shown_as_per_the_the_selected_category() throws Throwable {
    	ct = new Categories(driver);
    	ct.SortingPriceList();
    	// driver close
    	driver.quit();
    }
}
