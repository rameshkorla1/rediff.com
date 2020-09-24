package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import configuration.ebaylocators;


public class Categories implements ebaylocators {
	
	public WebDriver driver;
	
	public Categories(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By Category_Title = By.xpath(CategoryTitle);
	By search_textbox = By.xpath(searchBox);
	By Product_List = By.xpath(ProductList);	
	By Product_Title = By.xpath(ProductTitle);
	By PriceList = By.xpath(Price);
	By prices = By.xpath(Price);
	By Page_Title = By.xpath(PageTitle);
	
	By PageNavigate = By.xpath(Pagination);
	By Next = By.xpath("//a[@class='pagination__next']");
	By Previous = By.xpath("//a[@class='pagination__previous']");
	
	public WebElement NextButton()
	{
		return driver.findElement(Next);
	}
	public WebElement PreviousButton()
	{
		return driver.findElement(Previous);
	}
	
	public WebElement Category_Title()
	{
		return driver.findElement(Category_Title);
	}
	public WebElement Page_Title()
	{
		return driver.findElement(Page_Title);
	}
	public WebElement SearchTextbox()
	{
		return driver.findElement(search_textbox);
	}
	public WebElement PriceList()
	{		
		return driver.findElement(PriceList);
	}
	public WebElement Product_List()
	{
		return driver.findElement(Product_List);
	}
	
	public WebElement Product_Title()
	{
		return driver.findElement(Product_Title);
	}
	
	public WebElement Navigate()
	{
		return driver.findElement(PageNavigate);
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
			scroll();
			String productList = products.get(i).getText();
			SortingProductList();
			System.out.println(productList);
			System.out.println("============================ XXX =================================");
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
			System.out.println("------------------------- Price ---------------------------------");
		}
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
	public void SortingProductList()
	{
		List<WebElement>products=driver.findElements(Product_List);
		int count = products.size();
		for(int i=0;i<count; i++)
		{
			//scroll();
			String productList = products.get(i).getText();
			System.out.println(productList);
			Assert.assertEquals(Category_Title().getText(),"mobile phones");
			System.out.println(Category_Title().getText());
			System.out.println("------------------------- Products list ---------------------------------");
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
	public void productPagination()
	{   
		List<WebElement>products=driver.findElements(Product_List);
		List<String> productNames = new ArrayList();
		for(WebElement names: products)
		{
			productNames.add(names.getText());
			System.out.println(names.getText());
			System.out.println("============================ XXX =================================");
		}
		while(true)
		{
			NextButton().click();
			scroll();
			products=driver.findElements(Product_List);
			for(WebElement names: products)
			{
				productNames.add(names.getText());
				System.out.println(names.getText());
				System.out.println("============================ XXX =================================");
			}
			try {
				WebElement NextButton = driver.findElement(Next);
			} catch(Exception e)
			{
				break;				
			}
			
			System.out.println("============================ XXX =================================");
			break;
		}
	}
			
}
