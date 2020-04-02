package week1.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	public static void main(String[] args) {
		
				// set the system property
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				
				//open the chrome browser
				ChromeDriver driver = new ChromeDriver();
				
				// Open the URL
				driver.get("http://www.leafground.com/pages/Edit.html");
				
				// Implicit wait for 10 seconds
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				// Enter the email address
				driver.findElementById("email").sendKeys("a.m.akilandeshwari@gmail.com");
				
				// Append the text
				driver.findElementByXPath("//input[@value='Append ']").sendKeys("text", Keys.TAB);
				
				// Get default entered text
				String attribute = driver.findElementByXPath("(//input[@name='username'])[1]").getAttribute("value");
				System.out.println(attribute);
				
				// Clear the entered text
				driver.findElementByXPath("	(//input[@name='username'])[2]").clear();
				
				// Check whether it is enabled or disabled
				boolean enabled = driver.findElementByXPath("//input[@disabled='true']").isEnabled();
						System.out.println(enabled);
	}

}
