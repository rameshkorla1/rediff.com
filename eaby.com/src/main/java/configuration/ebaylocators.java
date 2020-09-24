package configuration;

public interface ebaylocators {

	String searchBox = "//input[@class='gh-tb ui-autocomplete-input']";
    String ProductList ="//div[@class='s-item__wrapper clearfix']";
    String ProductTitle="//div[@class='s-item__wrapper clearfix']//a//h3";
    String Price ="//span[@class='s-item__price']";
    String Postage="//span[@class='s-item__shipping s-item__logisticsCost']";
    String Bids ="//span[@class='s-item__bids s-item__bidCount']";
    
    String BestMatch ="//div[@class='srp-controls__sort srp-controls__control']//button";
    String LowestPrice="//span[text()='Lowest price']";   
    String HighestPrice ="//span[text()='Highest price']";
    
    String BuyitNow = "//*[@id='mainContent']/div[1]/div/div[1]/div[2]/div/div/ul/li[4]/a";
    
    String PageTitle ="(//ul[@class='srp-refine__category__list']//li//span)[4]";
    String CategoryTitle= "//span[text()='mobile phones']";
    
    String Pagination ="//a[@class='pagination__item']";
  
    
	
}
