package Project.MyFrameWork;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.DriverClass;
import resources.ExtentReporterNG;

public class Listeners extends DriverClass implements ITestListener
{
	ExtentTest test;
	
	ExtentReports er = ExtentReporterNG.getReportObject();
	
	//To take care of threadsafety
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		 test = er.createTest(result.getMethod().getMethodName());
		 //Once test takes one thread we make it in sync wit the other
		 tl.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//we are providing tl.get() before everytest to make it sync
		tl.get().log(Status.PASS, "Test Passsed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//failure log will be retieved and sent to this method
		//we are providing tl.get() before everytest to make it sync
		tl.get().fail(result.getThrowable());
		
		
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		try {
			tl.get().addScreenCaptureFromPath(Myscreenshot(testMethodName, driver),result.getMethod().getMethodName() );
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		try {
			Myscreenshot(testMethodName,driver);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		
			
		
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		er.flush();
		
	}

}
	