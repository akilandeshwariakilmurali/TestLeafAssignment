package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment1 {

	public static void main(String[] args) {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
				
		// Open the URL
		driver.get("https://acme-test.uipath.com/account/login");
				
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Enter username
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
				
		// Enter password
		driver.findElementById("password").sendKeys("leaf@12");
		
		// Click Login
		driver.findElementById("buttonLogin").click();
		
		// Mouse over on Vendors
		 
		WebElement ele = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");  
		Actions act = new Actions(driver);  
		act.moveToElement(ele).perform();
		
		// Click search vendor
		driver.findElementByLinkText("Search for Vendor").click();
		
		// Enter vendor name
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		// Click search
		driver.findElementById("buttonSearch").click();
		
		// Find country name
		String country = driver.findElementByXPath("(//table[@class='table']//td)[5]").getText();
		System.out.println(country);
		
		// Click Logout
		driver.findElementByLinkText("Log Out").click();
		
		// CLose the browser
		driver.close();
				
				
	}

}
