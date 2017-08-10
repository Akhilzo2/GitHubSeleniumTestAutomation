package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubHomePage {
	
	public static String userName=LoginPage.returnUserName();
	
	public static WebDriver driver;
	
	public static WebDriverWait wait ;

	public static String UserNameforValidation = "@"+userName;
	
	public static void loginValidation()
	{		
		driver = LoginPage.returnDriver();
		driver.findElement(By.xpath("//img[@alt='"+UserNameforValidation+"']")).click();
		
	}

}
