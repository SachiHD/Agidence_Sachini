package nopCommerceDataDriven.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nopCommerceDataDriven.pages.BaseTestClass;

import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.ArrayList;

public class Utilities extends BaseTestClass{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long	IMPLICIT_WAIT=20;
	
	public void waitForDisplayOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element_ = wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void scrollToSpecificElement(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
