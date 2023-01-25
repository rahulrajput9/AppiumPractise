package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.ReuseableUtils;

public class CartPage extends ReuseableUtils {
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	private WebElement eleTitle;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> eleCartProducts;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> eleCartProductPrices;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement eleCartPrice;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement eleTerms;
	
	@AndroidFindBy(id = "android:id/button1")
	private WebElement eleTermsCancel;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement eleCheckbutton;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement eleProcessPayment;
	
	public String getCartProduct() {
		waitAttributeContains(eleTitle, "text", "Cart");
		
		String cartProduct=eleCartProducts.get(0).getText();
		return cartProduct;
	}
	
	public double cartProductPrice() {
		waitAttributeContains(eleTitle, "text", "Cart");
		double sum=0;
		for(int i=0;i<eleCartProductPrices.size();i++) {
			
			String amount=eleCartProductPrices.get(i).getText();
			Double price= getStringFormattedPrice(amount);
			sum= sum+ price;
		}
		return sum;
	}
	
	public Double getcartPrice() {
		String displayed=eleCartPrice.getText();
		Double actualPrice=getStringFormattedPrice(displayed);
		return actualPrice;
	}
	
	public void getTerms() {
		longPressGesture(eleTerms);
		eleTermsCancel.click();
		
	}
	
	public void processPayment() {
		eleCheckbutton.click();
		eleProcessPayment.click();
	}

}
