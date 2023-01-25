package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.FormPage;
import resources.AppiumUtils;

public class Basics extends AppiumUtils{
	
	public AndroidDriver driver;
	public FormPage formpage;
	AppiumDriverLocalService appiumLocal;
	
	
	public AndroidDriver AppiumBase(String appName) throws IOException {
		
		Properties prop=new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\global.properties");
		prop.load(fis);
		
		String ip=prop.getProperty("ip");
		int port=Integer.parseInt(prop.getProperty("port"));
		
		appiumLocal=startAppiumService(ip,port);
		
		UiAutomator2Options op=new UiAutomator2Options();
		op.setDeviceName(prop.getProperty("deviceName"));
		op.setChromedriverExecutable(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		op.setApp(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+appName);
		
		driver= new AndroidDriver(appiumLocal.getUrl(),op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		formpage=new FormPage(driver);
		
		return driver;
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		appiumLocal.stop();
		
	}
}
