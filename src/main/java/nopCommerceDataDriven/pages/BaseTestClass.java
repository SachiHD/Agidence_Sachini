package nopCommerceDataDriven.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import nopCommerceDataDriven.util.Utilities;


public class BaseTestClass {
	
	public static WebDriver driver;
	public static Properties property;
	
	public BaseTestClass() {
		try {
			property=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\acer\\eclipse-workspace\\nopCommerceDataDriven\\src\\main\\java\\nopCommerceDataDriven\\config\\config.properties");
			property.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialization() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(property.getProperty("url"));
	}
}
