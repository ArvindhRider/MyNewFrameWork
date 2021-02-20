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
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
		
		
		//getting data from excel
		
		public static ArrayList<String> getdata(String testcasename, String sheetname, String columnname) throws IOException
		{
			ArrayList<String> a = new ArrayList();
			//we are getting inside the workbook
			FileInputStream fis=new FileInputStream("E:\\testing.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			
			//  we are understanding how many sheets are present in our workbook
			//from there we are going to our desired sheet 
			
			int sheetsinmyworkbook = workbook.getNumberOfSheets();
			for(int i=0; i<sheetsinmyworkbook;i++)
			{
				String sheetsavailable = workbook.getSheetName(i);
				//System.out.println(sheetsavailable);
				
				//getting inside our desired sheet
				if(sheetsavailable.equalsIgnoreCase(sheetname))
				{
					//get that sheet and place it here
					//get sheet at will do tat trick of getting inside that
					//desired sheet after if matching
					//we get the current sheet index
					XSSFSheet sheet = workbook.getSheetAt(i);
					
					//identifying the testcase scanning the entire first column of the sheet
					//Sheet is nothing but collection of rows!!!!!!
					Iterator<Row> rows = sheet.iterator();
					
					//we need to travel cell by cell inside a row so
					//first getting row object
					//from there going inside cell
					Row firstrow = rows.next();
					Iterator<Cell>cell= firstrow.iterator();
					// get the column index(0th column like that) where the testcases is present
					// we are declaring two vars here
					//why we need this is becoz one we identified that column index there only
					//we will go to the next row 
					int j=0;
					int coloumn =0;
					while(cell.hasNext())
					{
						Cell valueofcell = cell.next();
						//System.out.println(valueofcell.toString());
						if(valueofcell.toString().equalsIgnoreCase(columnname))
								{
							//System.out.println("I am in my desired column");
							break;
								}
						coloumn =j;
						j++;
						
					}
					//System.out.println(coloumn);
					
					//once that particular column containing the testcase name is identified then 
					//go look for the testcase name
					while(rows.hasNext())
					{
						Row r = rows.next();
						if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename))
						{
							//get all the cells available in that row
						Iterator<Cell> celldata=r.iterator();
					
						while(celldata.hasNext())
						{
							
							//System.out.println(celldata.next().getStringCellValue());
							String entries = celldata.next().toString();
							a.add(entries);
							
							
						}


						}
					}
					
					
				}
			}
			return a;
		}
		
		
			
		
}
