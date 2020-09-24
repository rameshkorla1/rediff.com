package TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
stepNotifications = true,		
features = { "src/test/java/features" },
glue = {"stepDefinations" },tags= {"@003"}, monochrome=true,
plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class ebayRunner {
	
}
 