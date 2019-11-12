package testBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class TestBase {
	
	public static WebDriver driver;
	
	
	public static WebDriver getDriver(){
		
		return driver;
		
		
	}
	
	
	
	private static void setDriver(String browser,String appURL,String OS) throws MalformedURLException{
		
		switch(OS){
		
		case "Windows":
			switch(browser){
			
			case"Chorme":
				driver=chormeDriver();
				break;
				
			case"Firefox":
				driver=firefoxDriver();
				break;
			case"IE":
				driver=IEDriver();
				break;
			}
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().to(appURL);
			//Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		
		}
	}
	
	
	public static WebDriver chormeDriver() throws MalformedURLException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kpott\\SeleniumAutomatiom\\SeleniumAutomation\\src\\test\\resources\\Driver\\chromedriver.exe");
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("test-type");
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		//RemoteWebDriver driver =new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"),options);
		
		WebDriver driver=new ChromeDriver(cap);
		
		return driver;
	}

	public static WebDriver firefoxDriver(){
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\Gecko Driver\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		
		FirefoxProfile profile=new FirefoxProfile();
		DesiredCapabilities capu=DesiredCapabilities.firefox();
		capu.setCapability(FirefoxDriver.PROFILE, profile);
		FirefoxOptions options=new FirefoxOptions();
		options.merge(capu);
		driver=new FirefoxDriver(options);
		return driver;
	}
	
	public static WebDriver IEDriver(){
		
		System.setProperty("webdriver.ie.driver", "\\src\\test\\resources\\Driver\\IEDriverServer.exe");
		
		DesiredCapabilities capbu=DesiredCapabilities.internetExplorer();
		capbu.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		WebDriver driver=new InternetExplorerDriver();
		return driver;
		
	
	}
	
	
	
	@BeforeSuite(groups = { "setup" })
	@Parameters({"browser","appURL","OS"})
	public static void initializeTestBaseSetup(String browser,String appURL,String OS) {
		
		try {
			if (driver == null) {
				
				System.out.println(browser);
				setDriver(browser, appURL, OS);
			}
		} catch (Exception e) {
			
		}
		
	}
	/*@AfterTest
	public static void quitSetup(){
		
		
			driver.quit();
	
	}*/

	}
