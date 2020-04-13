package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {


	public static void main(String[] args) throws InterruptedException {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://leafground.com/pages/Alert.html");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Simple Alert
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		
		//Confirm Alert
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
		String text1 = alert.getText();
		System.out.println(text1);
		alert.accept();
		
		// Prompt Alert
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
		alert.sendKeys("Test");
		alert.accept();
		
		// Sweet Alert
		driver.findElementByXPath("//button[text()='Sweet Alert']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='OK']").click();
		
		
		// Notification --> https://peter.sh/experiments/chromium-command-line-switches/
		}
}
