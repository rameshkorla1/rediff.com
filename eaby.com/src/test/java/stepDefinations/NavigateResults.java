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


public class NavigateResults extends DriverManager{
	Categories ct;
	WebDriverWait wait;
	@Given("User is a non registered customer and navigate to ebay site")
	public void user_is_a_non_registered_customer_and_navigate_to_ebay_site() throws Throwable {
		driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

	@When("User search for an item")
	public void user_search_for_an_item() throws Throwable {
        ct = new Categories(driver);
        ct.SearchTextbox().click();
        ct.SearchTextbox().sendKeys("iphone 11pro");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ct.SearchTextbox()));
        ct.SearchTextbox().sendKeys(Keys.DOWN);
        ct.SearchTextbox().sendKeys(Keys.ENTER);
    }

	@Then("User get a list of matching results display")
	public void user_get_a_list_of_matching_results_display() throws Throwable {
        ct = new Categories(driver);
        ct.Product_List();
    }

	@Then("the user can navigate through the pages to continue looking at the items")
	public void the_user_can_navigate_through_the_pages_to_continue_looking_at_the_items() throws Throwable {
    	 ct = new Categories(driver);
    	 ct.productPagination();
    }

    @And("the results show more than one page")
    public void the_results_show_more_than_one_page() throws Throwable {
    	 ct = new Categories(driver);
    	 ct.productPagination();
        
    }

}
