package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://flipkart.com");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Close X
		driver.findElementByXPath("//button[text()='✕']").click();

		// Maximize
		driver.manage().window().maximize();

		// Locate Electronics
		WebElement electronics = driver.findElementByXPath("//span[text()='Electronics']");

		// Mouse Hover electronics
		Actions act = new Actions(driver);
		act.moveToElement(electronics).perform();

		// CLick MI
		driver.findElementByLinkText("Mi").click();

		Thread.sleep(3000);
		
		// Verify title
		if (driver.getTitle().contains("Mi Mobile")) {
			System.out.println(" In MI page");
		}

	}

}
