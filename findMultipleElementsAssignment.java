package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findMultipleElementsAssignment {

	public static void main(String[] args) throws InterruptedException {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://leafground.com/pages/Image.html");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Number of images
		List<WebElement> total = driver.findElementsByTagName("img");
		System.out.println("Number of images " + total.size());

		// Click last image
		total.get(3).click();
		System.out.println(driver.getTitle());

		// Go to Radio button
		driver.navigate().to("http://leafground.com/pages/radio.html");

		// Number of radio buttons
		List<WebElement> radio = driver.findElementsByXPath("//input[@type='radio']");
		System.out.println("Number of radio buttons are " + radio.size());

		// Check all the check box
		driver.navigate().to("http://leafground.com/pages/checkbox.html");
		List<WebElement> checkbox = driver.findElementsByXPath("//input[@type='checkbox']");
		for (WebElement mark : checkbox) {
			if (!mark.isSelected()) {
				mark.click();
			}
		}
	}

}
