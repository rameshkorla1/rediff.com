package stepDefinations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;

public class SearchAndVerify extends DriverManager{
	
	public WebDriver driver;
	LandingPage lp;
	WebDriverWait wait;
	
	@Given("^User is a Non registered Customer and navigate to \"([^\"]*)\"$")
    public void user_is_a_non_registered_customer_and_navigate_to_something(String strArg1) throws Throwable {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @When("^User search for an Item$")
    public void user_search_for_an_item() throws Throwable {
        lp = new LandingPage(driver);
        lp.SearchTextbox().click();
        lp.SearchTextbox().sendKeys("Thinkpad");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lp.SearchTextbox()));
        lp.SearchTextbox().sendKeys(Keys.DOWN);
        lp.SearchTextbox().sendKeys(Keys.ENTER);
    }
    @Then("To get a list of matching results")
    public void to_get_a_list_of_matching_results() {
    	lp = new LandingPage(driver);
    	lp.ProductListName();
    	System.out.println("=============== $$ ============");
    }
    @And("^Verify the Items cards show: postage price, no of bids, price$")
    public void verify_the_items_cards_show_postage_price_no_of_bids_price() throws Throwable {
    	lp = new LandingPage(driver);
    	lp.Postages();
    	System.out.println("=============== $$ ============");
    	lp.Bids();
    	System.out.println("=============== $$ ============");
    	lp.price();
    	System.out.println("=============== $$ ============");
    }

    @When("user can sort the results by Lowest Price")
    public void user_can_sort_the_results_by_Lowest_Price() {
    	lp = new LandingPage(driver);
    	//lp.scrollUP();
        lp.BestMatchFilter().click();
        lp.LowestPrice().click();        
    }
    @Then("Verify the results are listed in the page incorrect order")
    public void verify_the_results_are_listed_in_the_page_incorrect_order() {
    	lp = new LandingPage(driver);
    	lp.SortingProductList();
        System.out.println("=============== $$ ============");
    }
    @When("^user can sort the results by Highest Price$")
    public void user_can_sort_the_results_by_highest_price() throws Throwable {
    	lp = new LandingPage(driver);
    	lp.BestMatchFilter().click();
    	lp.Highest_Price().click();
    	lp.SortingProductList();
    	System.out.println("=============== $$ ============");
    }
    @Then("^Verify the highest price results are listed in the page incorrect order$")
    public void verify_the_highest_price_results_are_listed_in_the_page_incorrect_order() throws Throwable {
    	lp = new LandingPage(driver);
    	lp.Postages();
    	System.out.println("=============== $$ ============");
    	lp.Bids();
    	System.out.println("=============== $$ ============");
    	lp.price();
    	System.out.println("=============== $$ ============");
    }
    @And("^user can filter the results by \"([^\"]*)\" and verify$")
    public void user_can_filter_the_results_by_something_and_verify(String strArg1) throws Throwable {
    	lp = new LandingPage(driver);
    	lp.BuyitNow().click();
    	lp.ProductListName();
    	System.out.println("=============== $$ ============");
    	driver.quit();
    }
	
}
