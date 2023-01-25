package testsPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Basics;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollTest extends Basics{
	AndroidDriver driver;
	
	@Test
	public void scrollTest() throws InterruptedException, IOException {
		driver=AppiumBase("ApiDemos-debug.apk");
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.
				androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		Thread.sleep(1000);
		
		
	}

}
