package nopCommerceDataDriven.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseTestClass{

	@FindBy(xpath = "//h1")
	WebElement lbl_title;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btn_Login;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}

	public String getLoginHeader() {
		String title=lbl_title.getText();
		return title;
	}

	public HomePage loginAsReturningCustomer(String email,String pw) {
		txt_email.sendKeys(email);
		txt_password.sendKeys(pw);
		btn_Login.click();
		
		return new HomePage();
	}
	
}
