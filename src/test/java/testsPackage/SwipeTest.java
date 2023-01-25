package testsPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Base.Basics;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwipeTest extends Basics{
	public AndroidDriver driver;
	
	@BeforeMethod
	public void preSetup() throws IOException {
		driver=AppiumBase("ApiDemos-debug.apk");
		}
	
	@Test
	public void testSwipe() throws IOException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstPic= driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(firstPic.getAttribute("focusable"), "true");
		
		formpage.swipeGesture(firstPic, "left");
		
		Assert.assertEquals(firstPic.getAttribute("focusable"), "false");
		
	}
	
	@Test
	public void testSwipeNegativeFAIL() throws IOException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstPic= driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(firstPic.getAttribute("focusable"), "true");
		
		formpage.swipeGesture(firstPic, "left");
		
		Assert.assertEquals(firstPic.getAttribute("focusable"), "true");
		
	}

}
