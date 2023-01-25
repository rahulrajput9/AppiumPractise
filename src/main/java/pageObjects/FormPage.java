package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.ReuseableUtils;

public class FormPage extends ReuseableUtils{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}


	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement eleNameField;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement eleMaleGenderButton;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement eleFemaleGenderButton;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement eleSelectCountry;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement eleShopButton;
	
	@AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
	private WebElement eleToast;
	
	public void giveName(String s) {
		eleNameField.sendKeys(s);
		driver.hideKeyboard();
	}
	
	public String getNameToastMessage() {
		String toastName=eleToast.getAttribute("name");
		return toastName;
	} 
	
	public void setGender(String gender) {
		if(gender.contains("female")) {
			eleFemaleGenderButton.click();
		}
		else 
			eleMaleGenderButton.click();
	}
	
	public void setCountry(String countryName) {
		eleSelectCountry.click();
		scrollIntoViewGesture(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public ProductCatalog letsShop() {
		eleShopButton.click();
		return new ProductCatalog(driver);
	}
	
	
	

}
