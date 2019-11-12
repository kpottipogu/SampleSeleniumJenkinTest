package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

public class CustomListeners implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("on Test Start  "+context.getName()+"Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("Test Suite***"+context.getName()+"ending");
		ExtentTestManager.endTest();
		ExtentReportTest.getInstance().flush();
		

	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Running Test Method::"+result.getMethod().getMethodName()+"....");
		ExtentTestManager.startTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Executed Test Method successfully::"+result.getMethod().getMethodName()+"....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	
		System.out.println("on Test Failure");
		
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 
		  TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "//ExtentReport//" + result.getName() + dateName + ".png";
		  File finalDestination = new File(destination);
		  try {
			FileHandler.copy(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			ExtentTestManager.getTest().fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getTest().log(Status.FAIL, "TestFailed");

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
		System.out.println("on Test Skipped");

	}

	
	

	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		

	}

}
