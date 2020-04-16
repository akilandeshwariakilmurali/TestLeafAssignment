package week3.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LearnSelenium4Features {

	public static void main(String[] args) {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// New window
		// driver.switchTo().newWindow(WindowType.WINDOW);
		
		// Opening a new tab
		driver.switchTo().newWindow(WindowType.TAB);

		driver.get("http://leaftaps.com/opentaps/control/main");
		
		// Relative Locator
		driver.findElement(RelativeLocator.withTagName("input").below(By.id("password"))).click();
		
	}

}
