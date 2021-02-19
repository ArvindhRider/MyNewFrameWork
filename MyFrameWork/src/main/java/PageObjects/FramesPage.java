package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage

{
	WebDriver driver;
	public FramesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
	
	@FindBy(className="demo-frame")
	WebElement frame;
	
	@FindBy(id="draggable")
	WebElement source;
	
	@FindBy(id="droppable")
	WebElement target;
	
	
	public WebElement firstframe()
	{
		return frame;
	}
	

	public WebElement source()
	{
		return source;
	}
	

	public WebElement target()
	{
		return target;
	}
	
	public Actions act(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	
	
	
	
	

}
