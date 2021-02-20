package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookPage 
{
	WebDriver driver;
	public void FacebookPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
	

	
	private By email = By.xpath("//input[@id='email']");
	private By pass = By.xpath("//div[@id='passContainer']");
	private By loginbutton = By.xpath("//button[@name='login']");
	
	
	public WebElement email()
	{
		return driver.findElement(email);
		
	}
	
	public WebElement pass()
	{
		return driver.findElement(pass);
	}
	
	public WebElement login()
	{
		return driver.findElement(loginbutton);
	}
	
	
	
	
	
	
	
	
	
	

}
