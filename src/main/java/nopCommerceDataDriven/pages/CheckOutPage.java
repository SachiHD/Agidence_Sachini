package nopCommerceDataDriven.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import nopCommerceDataDriven.util.Utilities;

public class CheckOutPage extends BaseTestClass{
	Utilities utils;
	
	@FindBy(xpath = "//h1")
	WebElement lbl_pageHeder;

	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
	WebElement dropDown_country;
	
	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']/option")
	WebElement option_country;
	
	@FindBy(xpath = "//select[@id='BillingNewAddress_StateProvinceId']")
	WebElement dropDown_state;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	WebElement input_city;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	WebElement input_address1;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement input_zip;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement input_phoneNumber;
	
	@FindBy(xpath = "//div[@id='billing-buttons-container']/button[@name='save']")
	WebElement btn_continue;
	
	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button[text()='Continue']")
	WebElement btn_continue_shiping;
	
	@FindBy(xpath ="// div[@id='shipping-methods-form'] //input[@id='shippingoption_1']/parent::div/following-sibling::div")
	WebElement lbl_shipingMentMethod;
	
	@FindBy(xpath = "//*[@id='shippingoption_1']")
	WebElement radio_ground;
	
	@FindBy(xpath = "//div[@id='payment-method-buttons-container']/button")
	WebElement btn_paymentMethod;
	
	@FindBy(xpath = "//*[@id='shippingoption_0']")
	WebElement radio_paymentMethod;
	
	@FindBy(xpath = "//input[@id='paymentmethod_0']//following-sibling::div[@class='payment-description']")
	WebElement lbl_paymentMethod;
	
	@FindBy(xpath = "//*[@id='payment-info-buttons-container']/button")
	WebElement btn_paymentInfor;
	
	@FindBy(xpath = "//*[@id='confirm-order-buttons-container']/button")
	WebElement btn_Orderconfirm;
	
	@FindBy(xpath = "// form[@id='co-payment-info-form']//tbody//p[1]")
	WebElement lbl_paymentInfor;
	
	@FindBy(xpath = "//div[@class='billing-info']")
	WebElement lbl_OC_biilingAddress;

	@FindBy(xpath = "//div[@class='shipping-info']")
	WebElement lbl_OC_shippingAddress;
	
	@FindBy(xpath = "//form[@id='shopping-cart-form']//tbody/tr/td[@class='product']/a")
	WebElement lbl_OC_products;
	
	@FindBy(xpath = "//form[@id='shopping-cart-form']//tbody/tr/td[@class='subtotal']")
	WebElement lbl_OC_subtotal;
	
	@FindBy(xpath = "//form[@id='shopping-cart-form']//tbody/tr[@class='order-total']//span/strong")
	WebElement lbl_OC_total;
	
	@FindBy(xpath = "//div[@class='order-number']/strong")
	WebElement lbl_OC_order;
	
	@FindBy(xpath = "//div[@class='section order-completed']/div[@class='title']/strong")
	WebElement lbl_Success;
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageHeader() {
		String title=lbl_pageHeder.getText();
		return title;
	}

	public void addShippingAddress() {
		Select country=new Select(dropDown_country);
		country.selectByVisibleText("Australia");
		
		Select state=new Select(dropDown_state);
		state.selectByVisibleText("Other");
		
		input_city.sendKeys("City");
		input_address1.sendKeys("Address1");
		input_zip.sendKeys("671230");
		input_phoneNumber.sendKeys("02158963");
		btn_continue.click();
		utils.waitForDisplayOfElement(btn_continue_shiping);
	}
	
	public void confirmShippingMethod() {
		radio_ground.click();
		btn_continue_shiping.click();
		utils.waitForDisplayOfElement(btn_paymentMethod);
	}
	
	public String verifyShippingBy() {
		String lbl=lbl_shipingMentMethod.getText();
		return lbl;
	}
	
	public void confirmPaymentMethod() {
		radio_paymentMethod.click();
		btn_paymentMethod.click();
		utils.waitForDisplayOfElement(btn_paymentInfor);
	}
	
	public void confirmPaymentMethodInfo() {
		btn_paymentInfor.click();
	}
	
	public String verifyPaymentMethod() {
		String lbl=lbl_paymentMethod.getText();
		return lbl;
	}
	
	public String paymentInforDetails() {
		String lbl=lbl_paymentInfor.getText();
		return lbl;
	}
	
	public void orderConfirm() {
		btn_Orderconfirm.click();
	}

	public Boolean verifyBillingAddress() {
		boolean flag=lbl_OC_biilingAddress.isDisplayed();
		return flag;
	}
	
	public Boolean verifyShippingAddress() {
		boolean flag=lbl_OC_biilingAddress.isDisplayed();
		return flag;
	}
	
	public String verifyOrderProductName() {
		String lbl=lbl_OC_products.getText();
		return lbl;
	}
	
	public String verifyOrderSubTotal() {
		String total=lbl_OC_subtotal.getText();
		return total;
	}
	
	public String verifyOrderTotal() {
		String total=lbl_OC_total.getText();
		return total;
	}
	
	public String verifySuccessfulOrderCreated() {
		String lbl=lbl_Success.getText();
		return lbl;
	}

	public Boolean verifyOrderCreated() {
		boolean flag=lbl_OC_order.isDisplayed();
		return flag;
	}
}
