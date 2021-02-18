package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{
	static ExtentReports er;
	public static ExtentReports getReportObject()
	{
		
		// we use two classes basically here
				//ExtentReports and ExtentSparkReporter
				
				//ExtentSparkReport is like the front end editor
				//using this we can entirely change the look and ui
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter esr = new ExtentSparkReporter(path);
				//we can completely change the view / frontend of the report 
				//with this esr object
				esr.config().setReportName("My First Automation Extent Report");
				esr.config().setDocumentTitle("Arvindh's Extent Report");
				
				//ExtentReport
				ExtentReports er = new ExtentReports ();
				//attaching both the classes
				er.attachReporter(esr);
				//incase if i need to mention the tester info
				er.setSystemInfo("Arvindh", "Windows");
				
				return er;
	}

}
