package testcase;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import testBase.TestBase;

public class SeleniumTest2 extends TestBase {
	
	
	@Test
	public void firstTest11() throws InterruptedException{
		
		Thread.sleep(2000);
		
	    System.out.println("driver Test2:"+ driver);

	    driver.findElement(By.name("q")).sendKeys("Selenium");
		
	    driver.findElement(By.name("btnK")).click();
		
		
		
	}


}
