package week1.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnString {

	public static void main(String[] args) {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		// Open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		
	    driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		// Text of "Welcome Demo Sales Manager"
		String text = driver.findElementByTagName("h2").getText();
		System.out.println(text);
        
		// Print "Demo Sales Manager"
        String substring2 = text.substring(8, text.length());
		System.out.println(substring2);

			
	}

}
