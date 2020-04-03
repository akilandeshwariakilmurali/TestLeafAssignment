package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
				
		// Open the URL
		driver.get("https://www.redbus.in");
				
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Enter From place
		driver.findElementById("src").sendKeys("Chennai");
		
		// wait
		Thread.sleep(5000);
		
		// Press Tab
		driver.findElementById("src").sendKeys(Keys.TAB);
		
		// Enter To Place
		driver.findElementById("dest").sendKeys("Bangalore");
		driver.findElementByXPath("//li[text()='Bangalore (All Locations)']").click();
		
		// Select the date
		driver.findElementById("onward_cal").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//div[@id='rb-calendar_onward_cal']/table[1]/tbody[1]/tr[7]/td[4]").click();
		
		// Click search buses
		driver.findElementById("search_btn").click();
		
		// Check "After 6pm" under Departure time
		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
		
		//Check "Sleeper" under Bus Type
		driver.findElementByXPath("//label[@title='SLEEPER']").click();
		
		// Click on "Seats available"
		driver.findElementByXPath("//div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[7]/a[1]").click();
		
		// CLose the browser
		driver.close();
				
				
	}

}