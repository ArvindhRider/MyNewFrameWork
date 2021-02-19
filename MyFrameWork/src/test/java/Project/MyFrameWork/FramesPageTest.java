package Project.MyFrameWork;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.FramesPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

import resources.DriverClass;


public class FramesPageTest extends DriverClass
{
WebDriver driver;
	
	
	//Introducing the log object here 
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void driverandurlTest() throws IOException
	{
		//This driver variable is already declared in Baseclass so we use it here
		//as we already have a var with the same type in our base class we are using this
		//else the other way arround is 
		// WebDriver d = initdriver();
		driver = initdriver();
		log.info("driver is started");
		driver.get(prop.getProperty("website"));
		log.info("Opned the site for frames");
		
		driver.manage().window().maximize();
		log.info("Maximize the window ");
		
	}
	@Test
	public void framestesting()
	{
		log.info("Switching to the frame first ");
		
		FramesPage fp = new FramesPage(driver);
		driver.switchTo().frame(fp.firstframe());
		
		
		log.info("finding the source and target nd moing them with actions ");
		
		fp.act(driver).dragAndDrop(fp.source(), fp.target()).build().perform();
	
	}
	
	
	

	@AfterSuite
	public void closAllTest()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	

}
