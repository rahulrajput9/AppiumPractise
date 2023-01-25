package generalStore;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Basics;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.CartPage;
import pageObjects.ProductCatalog;
import resources.Constants;

public class ECommerceTest_02 extends Basics {
	
	public AndroidDriver driver;
	
	@Test
	public void sumOfcartProducts() throws InterruptedException, IOException {
		driver=AppiumBase("General-Store.apk");
		formpage.giveName(Constants.enterName);
		formpage.setGender(Constants.enterGender);
		formpage.setCountry(Constants.selectCountry);
		
		ProductCatalog productCatalog= formpage.letsShop();
		
		productCatalog.displayedProductAddToCart();
		CartPage cartpage=productCatalog.goToCartPage();
	
		Double sum=cartpage.cartProductPrice();
		
		Double actual=cartpage.getcartPrice();
		
		Assert.assertEquals(sum, actual);	
		
		cartpage.getTerms();
		
		cartpage.processPayment();
		
		Thread.sleep(1000);
		
		Set<String> allContext=driver.getContextHandles();
		for(String context : allContext) {
			System.out.println(context);
		}
		
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Planit Testing Mumbai"+Keys.ENTER);
		
		Thread.sleep(1000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}

}
