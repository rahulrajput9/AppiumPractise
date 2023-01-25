package Base;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import resources.AppiumUtils;

public class BrowserBase extends AppiumUtils{
	
	AndroidDriver driver;
	AppiumDriverLocalService appiumLocal;
	
	
	public AndroidDriver AppiumBase() throws IOException {
		Properties prop=new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties");
		prop.load(fis);
		
		String ip=prop.getProperty("ip");
		int port=Integer.parseInt(prop.getProperty("port"));
		
		appiumLocal=startAppiumService(ip,port);
		
		UiAutomator2Options op=new UiAutomator2Options();
		op.setDeviceName(prop.getProperty("deviceName"));
		op.setChromedriverExecutable(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		op.setCapability("browserName", "Chrome");
		
		
		driver= new AndroidDriver(appiumLocal.getUrl(), op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	
	public void waitElementClickable(WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void waitAttributeContains(WebElement ele, String attribute, String value) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, attribute , value));
		
	}
	
	public Double getStringFormattedPrice(String s) {
		Double price=Double.parseDouble(s.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		appiumLocal.stop();
		
	}
}
