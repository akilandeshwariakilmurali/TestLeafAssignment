package week4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project {

	public static void main(String[] args) throws InterruptedException {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://dev28463.service-now.com/");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navigate to frame
		driver.switchTo().frame("gsft_main");

		// Enter username
		driver.findElementById("user_name").sendKeys("admin");

		// Enter Password
		driver.findElementById("user_password").sendKeys("yX1wLBuoGTm2");

		// Click Login button
		driver.findElementById("sysverb_login").click();

		// Enter in navigation filter
		driver.findElementById("filter").sendKeys("Change");
		Thread.sleep(3000);

		// Click create new
		driver.findElementByXPath("//div[text()='Create New']").click();
		Thread.sleep(3000);

		// Navigate to frame
		driver.switchTo().frame("gsft_main");

		// Click the link
		driver.findElement(By.linkText("Normal: Changes without predefined plans require approval and/or CAB authorization.")).click();;
		
		// GEt the change request number
		WebElement number = driver.findElement(By.id("change_request.number"));
		
		// Change number
		String changenumber = number.getAttribute("value");
		Thread.sleep(3000);
		
		// Enter short description
		driver.findElementById("change_request.short_description").sendKeys("Creating CR");
		
		// Click submit
		driver.findElementById("sysverb_insert").click();
		
		// Enter the created CR number
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input)[1]").sendKeys(changenumber, Keys.ENTER);
		Thread.sleep(3000);
		
		// Click the link
		driver.findElementByClassName("linked formlink").click();
		Thread.sleep(3000);
		
		// Verify the number
		String verifychn = driver.findElementById("change_request.number").getAttribute("value");
		if(changenumber.equals(verifychn)) {
			System.out.println("Number is same");
		}
		
		// Close the browser
		driver.close();
	}

}
