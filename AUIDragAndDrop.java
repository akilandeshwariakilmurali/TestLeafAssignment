package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AUIDragAndDrop {

	public static void main(String[] args) {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://leafground.com");

		// Implicit wait for 10 seconds

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click Droppable
		driver.findElementByXPath("//img[@alt='drop']").click();

		// Locate source and target
		WebElement source = driver.findElementById("draggable");
		WebElement target = driver.findElementById("droppable");

		// Drag and Drop
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

}
