package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnAUI {

	public static void main(String[] args) throws InterruptedException {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL driver.get("http://leafground.com/pages/selectable.html");

		// Implicit wait for 10 seconds

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Locating the webelements
		WebElement item4 = driver.findElementByXPath("//ol[@id='selectable']/li[4]");
		WebElement item5 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		WebElement item6 = driver.findElementByXPath("//ol[@id='selectable']/li[6]");
		WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']/li[7]");

		// Clicking multiple items
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(item4).click(item5).click(item6).click(item7).perform();

		// NAvigating to flipkart website
		driver.navigate().to("https://www.flipkart.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Close the X
		// driver.findElementByXPath("//button[text()='✕ ']").click();

		WebElement tv = driver.findElementByXPath("//span[text()='TVs & Appliances']");

		// mouse over tv and appliances
		act.moveToElement(tv).perform();

		driver.findElementByLinkText("LG").click();

		driver.findElementByXPath("(//div[@class='col col-7-12']//div)[1]").getText();
	}

}
