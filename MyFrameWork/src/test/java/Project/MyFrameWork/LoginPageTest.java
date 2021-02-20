package Project.MyFrameWork;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;

import resources.DriverClass;

public class LoginPageTest extends DriverClass
{
WebDriver driver;
	
	
	//Introducing the log object here 
	public static Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	
	@BeforeTest
	public void driverandurlTest() throws IOException
	{
		//This driver variable is already declared in Baseclass so we use it here
		//as we already have a var with the same type in our base class we are using this
		//else the other way arround is 
		// WebDriver d = initdriver();
		driver = initdriver();
		log.info("driver is started");
		
		
	}
	

	@Test(dataProvider = "getData")
	public void LoginPageTest(String user, String pass) throws InterruptedException
	{
	
		driver.get(prop.getProperty("url"));
		
		LandingPage lp=new LandingPage(driver);
		
		LoginPage lop=lp.loginOption();
		
		
		
		
		log.info("Login page is started");
		//Login page 
		
		
		
		log.info("the user is "+ user);
		lop.email().sendKeys(user);
		log.info("the user is "+ pass);
		lop.password().sendKeys(pass);
		lop.login().click();
		
		}
	

	@DataProvider
	public Object[][] getData() throws SQLException, IOException
	{
		ArrayList<String> al = DriverClass.jdbc();
		ArrayList<String> xl = DriverClass.getdata("thethirddoor","Books","Product name");
		
		//we are giving username and password for three sets of students here
		Object data[][]= new Object[3][2];
		
		//firstset is from db
		data[0][0] =al.get(0);
		data[0][1]= al.get(2);
		
		//manual entry trail
		data[1][0] ="tester2@gmail.com";
		data[1][1]= "passs";
		
		//thirdset from excel datasheet
		data[2][0] = xl.get(0);
		data[2][1] = xl.get(1);
		
		
		
		return data;
		
	}
	
	@AfterTest
	public void closAllTest()
	{
		driver.close();
	}
	
	
	
	

}
