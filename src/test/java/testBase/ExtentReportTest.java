package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest extends TestBase {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports createInstance(){
		
		htmlReporter=new ExtentHtmlReporter("C:\\Users\\kpott\\SeleniumAutomatiom\\SeleniumAutomation\\ExtentReport\\extentreport.html");
	
		htmlReporter.config().setDocumentTitle("Automation Report");
	
		htmlReporter.config().setReportName("HBI Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname", "LocalHost");
        extent.setSystemInfo("OS", "Windows10");
        extent.setSystemInfo("TesterName", "Kotaiah");
        extent.setSystemInfo("Browser", "Chrome");
        
        return extent;
	
	}
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			createInstance();
			return extent;
			
		}
		return extent;
	}
	
	/*public static WebElement fluentwait(final WebElement webElement, WebDriver driver) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return webElement;
			}

		});
		return webElement;
	}*/

	/*@Test
	public void firstTest() throws InterruptedException {

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.cssSelector("#gbw>div>div>div>div:nth-child(1)>a"));
		fluentwait(element, driver);
		element.click();
		//driver.findElement(By.cssSelector("input[name='btnK']")).click();
		
		
		//WebElement ele=driver.findElement(By.cssSelector("#rso>div:nth-child(1)>div>div>div>div>div>a>h3>div"));
		//fluentwait(ele, driver);
		//ele.click();
		
		WebElement ele=driver.findElement(By.cssSelector("#identifierId"));
		fluentwait(ele, driver);
		
		ele.sendKeys("kpottipogu");
		
        driver.findElement(By.cssSelector("#identifierNext")).click();
	}
	
	@AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus() == ITestResult.FAILURE) {
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	   String screenshotPath = ExtentReportTest.getScreenshot(driver, result.getName());
	   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
	  } else if (result.getStatus() == ITestResult.SKIP) {
	   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	  }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	  }
	  
	 }
	*/
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "//ExtentReport//" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileHandler.copy(source, finalDestination);
		  ExtentTestManager.getTest().fail("Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
		  return destination;
		 }	
}
