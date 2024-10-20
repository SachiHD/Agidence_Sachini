package nopCommerceDataDriven.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import nopCommerceDataDriven.util.Utilities;


public class HomePage extends BaseTestClass{
	Utilities utils;

	@FindBy(xpath="//title")
	WebElement title;
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement btn_login;
	
	@FindBy(xpath = "//a[text()='Log out']")
	WebElement btn_logout;
	
	@FindBy(xpath = "//input[@id='small-searchterms']")
	WebElement input_search;
	
	@FindBy(xpath = "//button[text()='Search']")
	WebElement btn_search;
	
	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement btn_addToCart;
	
	@FindBy(xpath = "//h2[@class='product-title']/a")
	WebElement lbl_itemText;
	
	@FindBy(xpath = "//strong[text()='News']")
	WebElement lbl_title_news;
	
	@FindBy(xpath = "//div[@class='short-description']")
	WebElement lbl_description;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
		
	}
	
	public String getHomePageTitle() {
		String homeTitle=title.getText();
		return homeTitle;
	}
	
	public LoginPage navigateToLoginPage() {
		btn_login.click();
		return new LoginPage();
	}
	
	public void filterItems(String itemName) {
		input_search.sendKeys(itemName);
		btn_search.click();
		utils.waitForDisplayOfElement(btn_addToCart);
		
	}

	public Boolean verifyUserIsLoggedIn() {
		boolean elementTextDisplay=btn_logout.isDisplayed();
		return elementTextDisplay;
	}
	
	public String verifyFilterItemDisplay() {
		String filterItemText=lbl_itemText.getText();
		return filterItemText;
	}
	
	public ItemSelectedPage selectElementFromList(String prodTitle) {
		utils.scrollToSpecificElement(lbl_title_news);
		List<WebElement> ele=  driver.findElements(By.xpath("//h2[@class='product-title']"));
		for(WebElement element: ele) {
			if(element.getText()==prodTitle) {
				btn_addToCart.click();
				utils.waitForDisplayOfElement(lbl_description);
			}
		}
		
		return new ItemSelectedPage();
	}
}
