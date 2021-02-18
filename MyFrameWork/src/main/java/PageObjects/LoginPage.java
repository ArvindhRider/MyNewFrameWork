package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



@FindBy(id="user_email")
WebElement emailid;

@FindBy(id="user_password")
WebElement password;

@FindBy(css=".btn.btn-primary.btn-md.login-button")
WebElement loginbutton;

	
	public WebElement email()
	{
		return emailid;
		
	}
	
	public WebElement password()
	{
		return password;
		
	}
	
	public WebElement login()
	{
		return loginbutton;
		
	}
	
	
	
}
