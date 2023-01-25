package testsPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basics;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DragDropTest extends Basics {
	AndroidDriver driver;
	
	@Test
	public void testDragDrop() throws InterruptedException, IOException {
		driver=AppiumBase("ApiDemos-debug.apk");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		formpage.dragDropGesture(source, 620, 560);
		
		Thread.sleep(1000);
		
		String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(result, "Dropped!");
	}

}
