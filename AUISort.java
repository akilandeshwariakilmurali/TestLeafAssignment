package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AUISort {

	public static void main(String[] args) {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://leafground.com");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Click Sortable
		driver.findElementByXPath("//img[@alt='sortable']").click();
		
		// Locate source and target to sort
		WebElement drag = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		int x = driver.findElementByXPath("//ul[@id='sortable']/li[4]").getLocation().getX();
		int y = driver.findElementByXPath("//ul[@id='sortable']/li[4]").getLocation().getY();
		System.out.println(x);
		System.out.println(y);
		
		// Drag and Drop
		Actions act = new Actions(driver);
		act.dragAndDropBy(drag, x, y).perform();
		
	}

}
