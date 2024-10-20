package nopCommerceDataDriven.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import nopCommerceDataDriven.pages.BaseTestClass;
import nopCommerceDataDriven.pages.HomePage;
import nopCommerceDataDriven.pages.LoginPage;

public class TestCaseLogin extends BaseTestClass{
	HomePage home;
	LoginPage login;
	
	public TestCaseLogin() {
		super();
	}
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		home=new HomePage();		
	}
	
	@Test(priority = 1)
	public void loginTonopCommerce() {
		Assert.assertEquals(home.getHomePageTitle(), "nopCommerce demo store");
		login=home.navigateToLoginPage();
		Assert.assertEquals(login.getLoginHeader(), "Welcome, Please Sign In!");
		
		login.loginAsReturningCustomer(property.getProperty("username"),property.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void loginToNopCommerceWithInvalidUser() {
		Assert.assertEquals(home.getHomePageTitle(), "nopCommerce demo store");
		login=home.navigateToLoginPage();
		Assert.assertEquals(login.getLoginHeader(), "Welcome, Please Sign In!");
		
		home=login.loginAsReturningCustomer("Test","Test");
		Assert.assertEquals(home.verifyUserIsLoggedIn(), true);
	}
	
}
