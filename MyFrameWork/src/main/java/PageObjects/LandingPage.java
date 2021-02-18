package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LandingPage 
{

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}





	
	By popup = By.xpath("//div[@class ='sumome-react-wysiwyg-move-handle'] //button[contains(text(),'NO THANKS')]");
	By login = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By title = By.xpath("//div[@class='text-center'] //h2[contains(text(), 'Featured Courses')]");
	By NaviBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public WebElement popcut()
	{
		return driver.findElement(popup);
		
	}
	
	public WebElement title()
	{
		return driver.findElement(title);
	}
	
	public WebElement NavBar()
	{
		return driver.findElement(NaviBar);
	}
	
	
	
	public LoginPage loginOption()
	{
		driver.findElement(login).click();
		LoginPage lop=new LoginPage(driver);
		 return lop;
		
		
	}
}
