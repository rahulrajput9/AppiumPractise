package testsPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import Base.Basics;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LongPressTest extends Basics {
	AndroidDriver driver;
	
	@Test
	public void TestLongPress() throws InterruptedException, IOException {
		driver=AppiumBase("ApiDemos-debug.apk");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		formpage.longPressGesture(ele);
		
		Thread.sleep(1000);
	
	}

}
