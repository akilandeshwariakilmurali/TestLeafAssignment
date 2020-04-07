package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findMultipleElements {

	public static void main(String[] args) throws InterruptedException {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://leafground.com/pages/Link.html");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Number of links
		int size = driver.findElementsByTagName("a").size();
		System.out.println(size);

		// CLick first link
		driver.findElementsByTagName("a").get(0).click();
		driver.getTitle();

		// Click second Go to home page 
		driver.navigate().back();
		//driver.findElementsByTagName("a").get(4).click();

		List<WebElement> links = driver.findElementsByLinkText("Go to Home Page");
		System.out.println(links.size());
		links.get(1).click();

		driver.findElementByXPath("(//a[text()='Go to Home Page'])[last()]/following-sibling::label").getText();

	}

}
