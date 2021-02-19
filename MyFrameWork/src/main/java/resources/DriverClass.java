package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import okio.Options;

public class DriverClass 
{
	//Declare Webdriver and Properties globally to access everywhere
	public WebDriver driver;
	public Properties prop;
	
	//This same variable can be used in all the extending classes to get the driver power

	
	
	
	
		public WebDriver initdriver() throws IOException
	{
		//Reading the data from the prop file and passing it here 
		 prop = new Properties();
		String PropPath = "C:\\Users\\ARVINDH\\git\\repository\\MyFrameWork\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(PropPath);
		prop.load(fis);
		
		//String browsername= prop.getProperty("browser");    //prop.getProperty has the return type of string 
		String browsername = System.getProperty("browser");
		
		//Selecting the browser
		if(browsername.contains("chrome"))
		{
			System.out.println("Chrome ");
			System.setProperty("webdriver.chrome.driver", "E:\\2021_Selenium\\BrowserDrivers\\chromedriver.exe");
			
			//To perform headless mode of running 
			ChromeOptions options = new ChromeOptions();
			if(browsername.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			 driver = new ChromeDriver(options);
		}
		else if(browsername.equalsIgnoreCase("Firefox"))
		{
			System.out.println("Firefox");
			System.setProperty("webdriver.gecko.driver", "E:\\2021_Selenium\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			System.out.println("Edge");
		}
		
		//implicit waiting at global base
		//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		return driver;
		
		
	}
		
		public String Myscreenshot(String TestcaseName, WebDriver driver) throws IOException
		{
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			//user dir gives the path of that project
			String destination = System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
			FileUtils.copyFile(src, new File(destination));
			return destination;
		}
		
		public static ArrayList<String> jdbc() throws SQLException
		{
			ArrayList<String> al = new ArrayList<String>();
			String host="localhost";

			String port= "3306";
			//connection line 
			Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/ra","root","AmazonR@5");
			
			//to pass our sql statements 
			Statement s=con.createStatement();
			ResultSet rs = s.executeQuery("select * from employee");

			while(rs.next())
			{
				String names =  rs.getString("name");
				
				al.add(names);
			}
			
			return al;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
