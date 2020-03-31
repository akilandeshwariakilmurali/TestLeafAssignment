package week1.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUsingWD {

	public static void main(String[] args) {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		// Open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		// Get the title
		driver.getTitle();
		
		//Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		
		// Clicking Login button
		driver.findElementByClassName("decorativeSubmit").click();
		
		// Click on CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
	}

}
