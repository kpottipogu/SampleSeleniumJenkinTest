package testcase;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import testBase.TestBase;

public class SeleniumTest extends TestBase {

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
	}
*/
	@Test
	public void firstTest() throws InterruptedException {

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.cssSelector("#gbw>div>div>div>div:nth-child(1)>a"));
		//fluentwait(element, driver);
		element.click();
		//driver.findElement(By.cssSelector("input[name='btnK']")).click();
		
		
		//WebElement ele=driver.findElement(By.cssSelector("#rso>div:nth-child(1)>div>div>div>div>div>a>h3>div"));
		//fluentwait(ele, driver);
		//ele.click();
		
		//WebElement ele=driver.findElement(By.cssSelector("#identifierId"));
		//fluentwait(ele, driver);
		
		//ele.sendKeys("kpottipogu");
		
       // driver.findElement(By.cssSelector("#identifierNext")).click();
	}

}
