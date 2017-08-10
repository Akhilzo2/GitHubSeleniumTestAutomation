package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

public class LoginPage {
	
	public static WebDriver driver;
	public static WebDriverWait wait ;
		
	@FindBy(how=How.ID, using="login_field")
	public static WebElement UserNameTextField;
	
	@FindBy(how=How.ID, using="password")
	public static WebElement PasswordTextField;
	
	@FindBy(how=How.XPATH, using="//h1[text()='Sign in to GitHub']")
	public static WebElement SignInToGitHubHeader;
	
	@FindBy(how=How.NAME, using="commit")
	public static WebElement SignInButton;
	
	public static String userName;
	
	@FindBy(how=How.XPATH, using="//div[@class='flash flash-full flash-error']")
	public static WebElement LoginFailedErrorMessage;
	
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Sign in')]")
	public static WebElement SignInLink;
	
	
	public static void launchGitHub()
	{
			
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("--incognito");
		options.addArguments("--start-maximized");
		Logger.getRootLogger().setLevel(Level.OFF);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.get("https://github.com/");
		
		
		wait =new WebDriverWait(driver, 20);
		
		PageFactory.initElements(driver, LoginPage.class);
		
		wait.until(ExpectedConditions.elementToBeClickable(SignInLink));	
		SignInLink.click();
		
		wait.until(ExpectedConditions.visibilityOf(SignInToGitHubHeader));			
		
	}
	
	
	public static void fnLogin(DataTable loginData)
	{
		
		
		
		wait =new WebDriverWait(driver, 20);
		List<Map<String,String>> LoginTable = loginData.asMaps(String.class, String.class);
		 userName = LoginTable.get(0).get("UserName");
		String passWord = LoginTable.get(0).get("Password");
		
		

		wait.until(ExpectedConditions.visibilityOf(UserNameTextField));	
		UserNameTextField.sendKeys(userName);
		wait.until(ExpectedConditions.visibilityOf(PasswordTextField));		
		PasswordTextField.sendKeys(passWord);	
		wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
		SignInButton.click();
		
	}
	
	public static void unsuccessfullLoginvalidation()
	{
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginFailedErrorMessage));
		
	}

	
public static String returnUserName()
{
	return userName;
}

public static WebDriver returnDriver()
{
	return driver;
}


	

}
