package generalStore;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Basics;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.CartPage;
import pageObjects.ProductCatalog;
import resources.Constants;

public class ECommerceTest_01 extends Basics{
	public AndroidDriver driver;
	
	@BeforeMethod
	public void preSetup() throws IOException {
		driver=AppiumBase("General-Store.apk");
		formpage.directstartActivity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
	}
	
	
	@Test
	public void fillFormPositiveTest() throws InterruptedException, MalformedURLException {
		
		formpage.giveName(Constants.enterName);
		formpage.setGender(Constants.enterGender);
		formpage.setCountry(Constants.selectCountry);
		
		ProductCatalog productCatalog= formpage.letsShop();
		
		productCatalog.selectProduct(Constants.productName);
		
		CartPage cartpage=productCatalog.goToCartPage();
		
		Assert.assertEquals(cartpage.getCartProduct(), Constants.productName);
		
		Thread.sleep(1000);
	}

	@Test
	public void fillFormNegativeTest() throws InterruptedException, MalformedURLException {
		
		formpage.setGender(Constants.enterGender);
		formpage.setCountry(Constants.selectCountry);
		formpage.letsShop();
		
		String toastName= formpage.getNameToastMessage();
		Assert.assertEquals(toastName, "enter your name");
		
		Thread.sleep(1000);
	}
}
