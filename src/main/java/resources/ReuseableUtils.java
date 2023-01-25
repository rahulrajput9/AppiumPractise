package resources;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class ReuseableUtils {
	AndroidDriver driver;

	public ReuseableUtils(AndroidDriver driver) {
		this.driver = driver;
		
	}
	
	public void longPressGesture(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.
				of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
		
	}
	
	public void swipeGesture(WebElement ele,String direction) {
		
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.
				of("elementId", ((RemoteWebElement)ele).getId(),"direction",direction, "percent",0.75 ));
	}
	
	public void dragDropGesture(WebElement ele, int x, int y) {
		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", ImmutableMap.
				of("elementId",((RemoteWebElement)ele).getId(),"endX",x,"endY",y));
	}
	
	public void directstartActivity(String packageName, String activityName) {
		Activity activity= new Activity(packageName, activityName);
		driver.startActivity(activity);
	}
	
	public void waitAttributeContains(WebElement ele, String attribute, String value) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, attribute , value));
		
	}
	
	public void scrollIntoViewGesture(String s) {
		driver.findElement(AppiumBy.
				androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ s +"\"));"));
	}
	
	public Double getStringFormattedPrice(String s) {
		Double price=Double.parseDouble(s.substring(1));
		return price;
	}
	
	

}
