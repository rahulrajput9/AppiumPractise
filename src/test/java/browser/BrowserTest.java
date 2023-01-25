package browser;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Base.BrowserBase;
import io.appium.java_client.android.AndroidDriver;

public class BrowserTest extends BrowserBase {
	public AndroidDriver driver;
	
	@BeforeMethod
	public void preSetup() throws IOException {
		driver=AppiumBase();
	}
	
	@Test
	public void browserOpenTest() throws InterruptedException {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Planit Testing Mumbai"+Keys.ENTER);
		
		driver.findElement(By.xpath("(//div[contains(text(),'Website')])[1]")).click();
		
		WebElement hamburgerLanging=driver.findElement(By.xpath("//img[@id='hamburgerIconW']"));
		
		waitElementClickable(hamburgerLanging);
		Thread.sleep(1000);
		hamburgerLanging.click();
		
		waitElementClickable(driver.findElement(By.xpath("(//i[@id='170-expend'])[2]")));
		driver.findElement(By.xpath("(//i[@id='170-expend'])[2]")).click();
		
		
		WebElement element=driver.findElement(By.xpath("//li[@id='rpa']"));
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		
		String eleText= element.getText();		
		
		Thread.sleep(1000);
		
		
		element.click();
		
		String titleText=driver.getTitle();
		System.out.println(titleText);
		
		Assert.assertTrue(titleText.endsWith(eleText));
	}
	
	@Test
	public void browserOpenTestNegativeFAIL() throws InterruptedException {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Planit Testing Mumbai"+Keys.ENTER);
		
		driver.findElement(By.xpath("(//div[contains(text(),'Website')])[1]")).click();
		
		WebElement hamburgerLanging=driver.findElement(By.xpath("//img[@id='hamburgerIconW']"));
		
		waitElementClickable(hamburgerLanging);
		Thread.sleep(1000);
		hamburgerLanging.click();
		
		waitElementClickable(driver.findElement(By.xpath("(//i[@id='170-expend'])[2]")));
		driver.findElement(By.xpath("(//i[@id='170-expend'])[2]")).click();
		
		
		WebElement element=driver.findElement(By.xpath("//li[@id='rpa']"));
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)", "");
		
		String eleText= element.getText();		
		
		Thread.sleep(1000);
		
		
		element.click();
		
		String titleText=driver.getTitle();
		System.out.println(titleText);
		
		Assert.assertTrue(titleText.startsWith(eleText));
	}

}
