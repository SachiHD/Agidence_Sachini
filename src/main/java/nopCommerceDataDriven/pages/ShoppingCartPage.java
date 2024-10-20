package nopCommerceDataDriven.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import nopCommerceDataDriven.util.Utilities;

public class ShoppingCartPage extends BaseTestClass {
	Utilities utils;
	
	@FindBy(xpath = "//h1")
	WebElement lbl_pageHeader;
	
	@FindBy(xpath = "//div[@class='table-wrapper']//tbody/tr/td/a[@class='product-name']")
	WebElement lbl_prodName;
	
	@FindBy(xpath = "//input[@name='termsofservice']")
	WebElement input_agreeTerms;
	
	@FindBy(xpath = "//button[text()=' Checkout ']")
	WebElement btn_checkout;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageHeader() {
		String labelHeader=lbl_pageHeader.getText();
		return labelHeader;
	}

	public String verifyAddedItemName() {
		String lbl=lbl_prodName.getText();
		return lbl;
	}

	public CheckOutPage checkoutSelectedItem() {
		input_agreeTerms.click();
		btn_checkout.click();
		return new CheckOutPage();
		
	}
}
