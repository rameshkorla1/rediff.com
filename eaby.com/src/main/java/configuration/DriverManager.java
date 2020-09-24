package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{	
	 prop= new Properties();
	 String propertiesfilePath =System.getProperty("user.dir")+"/src/main/java/configuration/eabyconfig.properties";
	 FileInputStream fis=new FileInputStream(propertiesfilePath);
	 prop.load(fis);
	 String browserName=prop.getProperty("browser");
	 System.out.println(browserName);
	if(browserName.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	else if (browserName.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		 driver= new FirefoxDriver();
	
	}
	else if (browserName.equals("IE"))
	{
//		IE code
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}

public String getReportConfigPath(){

 String reportConfigPath = System.getProperty("user.dir")+"/config/extent-config.xml";
 if(reportConfigPath!= null) return reportConfigPath;
 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
}
}
