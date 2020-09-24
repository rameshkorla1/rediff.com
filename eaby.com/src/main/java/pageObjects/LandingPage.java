package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import configuration.ebaylocators;




public class LandingPage implements ebaylocators{
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By search_textbox = By.xpath(searchBox);
	By Product_List = By.xpath(ProductList);	
	By Product_Title = By.xpath(ProductTitle);
	
	By BestMatchFilter = By.xpath(BestMatch);
	By Lowest_Price = By.xpath(LowestPrice);
	By Highest_Price = By.xpath(HighestPrice);
	By PriceList = By.xpath(Price);
	
	By Postages = By.xpath(Postage);
	By bids = By.xpath(Bids);
	By prices = By.xpath(Price);
	By BuyItNow = By.xpath(BuyitNow);
	
	By Page_Title = By.xpath(PageTitle);
	
	public WebElement SearchTextbox()
	{
		return driver.findElement(search_textbox);
	}
    
	public WebElement Product_List()
	{
		return driver.findElement(Product_List);
	}
	
	public WebElement Product_Title()
	{
		return driver.findElement(Product_Title);
	}
	
	public WebElement BestMatchFilter()
	{
		return driver.findElement(BestMatchFilter);
	}
	
	public WebElement LowestPrice()
	{
		return driver.findElement(Lowest_Price);
	}
	
	public WebElement PriceList()
	{		
		return driver.findElement(PriceList);
	}
	
	public WebElement Highest_Price()
	{
		return driver.findElement(Highest_Price);
	}
	
	public WebElement BuyitNow()
	{
		return driver.findElement(BuyItNow);
	}
	public WebElement Page_Title()
	{
		return driver.findElement(Page_Title);
	}
	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
    }
	
	public void scrollUP()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-800)", "");
	}
	
	public void ProductList()
	{
		List<WebElement>products=driver.findElements(Product_List);
		int count = products.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String productList = products.get(i).getText();
			System.out.println(productList);
			System.out.println("============================ XXX =================================");
		}
	}
	
	public void ProductListName()
	{
		List<WebElement>products=driver.findElements(Product_Title);
		int count = products.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String productList = products.get(i).getText();
			System.out.println(productList);	
			//Assert.assertEquals(Page_Title().getText(), "PC Laptops & Netbooks");
			System.out.println("============================ Product Name =================================");
			System.out.println(Page_Title().getText());
		}
	}
	
	public void Postages()
	{
		List<WebElement>postages=driver.findElements(Postages);
		int count = postages.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String postagesList = postages.get(i).getText();
			System.out.println(postagesList);	
			System.out.println("------------------------- Postages ---------------------------------");			
		}
	}
	public void Bids()
	{
		List<WebElement>bids1=driver.findElements(bids);
		int count = bids1.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String bidsList = bids1.get(i).getText();
			System.out.println(bidsList);	
			System.out.println("------------------------- Bids ---------------------------------");
		}
	}
	public void price()
	{
		List<WebElement>pricelist=driver.findElements(prices);
		int count = pricelist.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String priceList = pricelist.get(i).getText();
			SortingPriceList();
			System.out.println(priceList);		
			System.out.println("-------------------------Price ---------------------------------");
		}
	}
	
	public void SortingProductList()
	{
		List<WebElement>products=driver.findElements(Product_List);
		int count = products.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String productList = products.get(i).getText();
            SortProductList();
			System.out.println(productList);
			System.out.println("------------------------- Product List ---------------------------------");
		}
		
	}
	public void SortingPrice()
	{
		List<WebElement> price = driver.findElements(PriceList);
		// extract the prices from the price elements and store in a List
		List<String> prices = new ArrayList<String>();
		for (WebElement e : price)
		{
		    prices.add(e.getText());
		}
	    // make a copy of the list
		List<String> sortedPrices = new ArrayList<String>(prices);
		// sort the list
		Collections.sort(sortedPrices);
		// true if the prices are sorted
		System.out.println(sortedPrices.equals(prices));
		//Assert.assertEquals(sortedPrices, prices);
	}
	
	public void SortingPriceList()
	{
		boolean flag = false;
		 List<WebElement> list = driver.findElements(PriceList);
		 int size = list.size();
		 String[] actual = new String[size]; 
		 String[] sorted = new String[size];

		 for (int i = 0; i < size; i++) 
		 {
		    actual[i]=sorted[i] = driver.findElement(PriceList).getText();
		 }

		 //Sorting the array
		 Arrays.sort(sorted);
		 //Validating the existing with sorted array. shows no message if both are same
		 for(int i = 0;i<size;i++)
		 {
		     if(!actual[i].equals(sorted[i]))
		     {
		         System.out.println("The elements the webpage are not sorted");
		         System.out.println("expected "+sorted[i]+" but actual "+actual[i]+" at row "+i);
		         flag = true;
		     }
		 }
	}
	public void SortProductList()
	{
		 boolean flag = false;
		 List<WebElement> list = driver.findElements(Product_List);
		 int size = list.size();
		 String[] actual = new String[size]; 
		 String[] sorted = new String[size];

		 for (int i = 0; i < size; i++) 
		 {
		    actual[i]=sorted[i] = driver.findElement(Product_List).getText();
		 }

		 //Sorting the array
		 Arrays.sort(sorted);

		 //Validating the existing with sorted array. shows no message if both are same
		 for(int i = 0;i<size;i++)
		 {
		     if(!actual[i].equals(sorted[i]))
		     {
		         System.out.println("The elements the webpage are not sorted");
		         System.out.println("expected "+sorted[i]+" but actual "+actual[i]+" at row "+i);
		         flag = true;
		     }
		 }
	}
}
