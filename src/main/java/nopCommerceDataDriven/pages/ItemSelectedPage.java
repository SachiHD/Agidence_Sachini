package nopCommerceDataDriven.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nopCommerceDataDriven.util.Utilities;

public class ItemSelectedPage extends BaseTestClass{
	Utilities utils;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement btn_addToCart;
	
	@FindBy(xpath = "//div[@class='bar-notification success']")
	WebElement element_NotificationBar;
	
	@FindBy(xpath = "//div[@class='bar-notification success']/p")
	WebElement lbl_notificationCOntent;
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	WebElement link_shoppingCart;
	
	public ItemSelectedPage() {
		PageFactory.initElements(driver,this);
	}
		
	public Boolean verifySuccessfulItemAdd() {
		boolean flag=element_NotificationBar.isDisplayed();
		return flag;
	}
	
	public void addItemIntoCart() {
		btn_addToCart.click();
		utils.waitForDisplayOfElement(element_NotificationBar);
		
	}
	
	public String labelContent() {
		String label=lbl_notificationCOntent.getText();
		return label;
	}
	
	public ShoppingCartPage navigateToShoppingCart() {
		link_shoppingCart.click();
		return new ShoppingCartPage();
	}
	
}
