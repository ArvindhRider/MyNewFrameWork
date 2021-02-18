package Project.MyFrameWork;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//Importing all the page objects here	
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.DriverClass;

public class HomePageTest extends DriverClass
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
		
		// as prop is declared as a public in driver class we use it here when we extend that class
		driver.get(prop.getProperty("url"));
		log.info("url is started");
	}
	
		
	

	
	@Test
	public void LandingPageTest() throws IOException, InterruptedException
	{
		
		
		
		
		//Landing Page
		//Creating a class object and passing the driver there 
		//at the receiving end we create a const to get the power
		//and provide it to the local driver variable
		LandingPage lp = new LandingPage(driver);
		log.info("Landing page is started ");
	
	
		//Assertion tech
		Assert.assertEquals(lp.title().getText(), "FEATURErD COURSES");
		
		//To check if navigation bar is present
		Assert.assertTrue(lp.NavBar().isDisplayed());
		
		
		
		
		
	}
	
	
	
	@AfterTest
	public void closAllTest()
	{
		driver.close();
	}
}
