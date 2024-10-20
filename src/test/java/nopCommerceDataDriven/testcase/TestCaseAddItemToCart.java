package nopCommerceDataDriven.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import nopCommerceDataDriven.pages.BaseTestClass;
import nopCommerceDataDriven.pages.CheckOutPage;
import nopCommerceDataDriven.pages.HomePage;
import nopCommerceDataDriven.pages.ItemSelectedPage;
import nopCommerceDataDriven.pages.LoginPage;
import nopCommerceDataDriven.pages.ShoppingCartPage;

public class TestCaseAddItemToCart extends BaseTestClass{
	
	HomePage home;
	LoginPage login;
	ItemSelectedPage item;
	ShoppingCartPage cart;
	CheckOutPage checkout;
	
	
	public TestCaseAddItemToCart() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		
		home=new HomePage();
		login=home.navigateToLoginPage();
		home=login.loginAsReturningCustomer(property.getProperty("username"),property.getProperty("password"));
		Assert.assertEquals(home.verifyUserIsLoggedIn(), true);
		
	}
	
	@Test(priority = 1)
	public void testfilterItemByText() {
		home.filterItems("Computer");
		Assert.assertEquals(home.verifyFilterItemDisplay(), "Build your own computer");
		
		
	}
	
	@Test(priority = 2)
	public void testAddItemsToCart_NoFilter() {
		String proName="Build your own computer";
		item=home.selectElementFromList(proName);
		item.addItemIntoCart();
		Assert.assertEquals(item.verifySuccessfulItemAdd(), true);
		Assert.assertEquals(item.labelContent(), "The product has been added to your ");
		cart=item.navigateToShoppingCart();
		Assert.assertEquals(cart.verifyPageHeader(), "Shopping cart");
		Assert.assertEquals(cart.verifyAddedItemName(), proName);
	}
	
	@Test(priority = 3)
	public void checkoutAddedItemsInCart() {
		String proName="Build your own computer";
		item=home.selectElementFromList(proName);
		item.addItemIntoCart();
		cart=item.navigateToShoppingCart();
		checkout=cart.checkoutSelectedItem();
		Assert.assertEquals(checkout.verifyPageHeader(),"Checkout");
		checkout.addShippingAddress();
		
		Assert.assertEquals(checkout.verifyShippingBy(), "The one day air shipping");
		checkout.confirmShippingMethod();
		
		Assert.assertEquals(checkout.verifyPaymentMethod(), "Pay by cheque or money order");
		checkout.confirmPaymentMethod();
		
		Assert.assertEquals(checkout.verifyPaymentMethod(), "Pay by cheque or money order");
		checkout.confirmPaymentMethodInfo();
		
		Assert.assertEquals(checkout.paymentInforDetails(),"Mail Personal or Business Check, Cashier's Check or money order to:" );
		checkout.confirmPaymentMethodInfo();
		
		checkout.orderConfirm();
		
		Assert.assertEquals(checkout.verifyBillingAddress(), true);
		Assert.assertEquals(checkout.verifyShippingAddress(), true);
		Assert.assertEquals(checkout.verifyOrderProductName(), "proName");
		
		checkout.orderConfirm();
		Assert.assertEquals(checkout.verifyPageHeader(), "Thank you");
		Assert.assertEquals(checkout.verifyOrderCreated(), true);
		
		Assert.assertEquals(checkout.verifySuccessfulOrderCreated(),"Your order has been successfully processed!" );
	}
	
}
