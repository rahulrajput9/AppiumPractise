package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.ReuseableUtils;

public class ProductCatalog extends ReuseableUtils{
	AndroidDriver driver;
	
	public ProductCatalog(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> eleProducts;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> eleAddToCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement eleCartButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> eleDisplayedAddToCart;
	
	public void selectProduct(String s) {
		scrollIntoViewGesture(s);
		for(int i=0; i<eleProducts.size();i++) {
			String productName=eleProducts.get(i).getText();
			if(productName.equalsIgnoreCase(s)) {
				eleAddToCart.get(i).click();
			}
			
		}
	}
	
	public void displayedProductAddToCart() {
		eleDisplayedAddToCart.get(0).click();
		eleDisplayedAddToCart.get(0).click();
		
	}
	
	public CartPage goToCartPage() throws InterruptedException {
		eleCartButton.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}

}
