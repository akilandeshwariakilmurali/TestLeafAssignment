package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {


	public static void main(String[] args) throws InterruptedException {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		
		// click the button
		driver.findElementByXPath("//button[text()='Try it']").click();
		
		// switch to Alert
		Alert alert2 = driver.switchTo().alert();
		
		// Click ok
		alert2.accept();
		
		}
}
