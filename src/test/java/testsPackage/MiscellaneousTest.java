package testsPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import Base.Basics;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousTest extends Basics{
	AndroidDriver driver;
	@Test
	public void rotateCopyPasteDirectStartTest() throws IOException {
		driver=AppiumBase("ApiDemos-debug.apk");
		
		formpage.directstartActivity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation rotate= new DeviceRotation(0, 0, 90);
		driver.rotate(rotate);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		driver.setClipboardText("Rajput wifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	

}
