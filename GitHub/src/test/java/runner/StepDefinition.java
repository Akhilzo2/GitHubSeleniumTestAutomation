package runner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.GitHubHomePage;
import pageObjects.LoginPage;

public class StepDefinition {
	
	
@Given("^The GitHub Website is up and running$")
public void the_GitHub_Website_is_up_and_running() throws Throwable {
	LoginPage.launchGitHub();  
}

@When("^The user logs into GitHub with the following credentials$")
public void the_user_logs_into_GitHub_with_the_following_credentials(DataTable loginData) throws Throwable {
    
	LoginPage.fnLogin(loginData);
}

@Then("^The login should be successfull$")
public void the_login_should_be_successfull() throws Throwable {
    
	GitHubHomePage.loginValidation();
}

@Then("^The login should be unsuccessfull$")
public void the_login_should_be_unsuccessfull() throws Throwable {
    
LoginPage.unsuccessfullLoginvalidation();

}

@After
public  void afterClass(Scenario scenario){
	
	WebDriver driver = LoginPage.returnDriver();
	
	
	if(scenario.isFailed()) {
		try {
		scenario.write("Current Page URL is " + driver.getCurrentUrl());
		byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");
		} 
		catch (WebDriverException somePlatformsDontSupportScreenshots) {
		System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		} 
		}
		driver.quit();
		
	System.out.println(scenario.getName()+" : "+scenario.getStatus());
	
}

}
