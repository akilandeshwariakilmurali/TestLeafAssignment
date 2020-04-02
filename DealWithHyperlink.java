package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DealWithHyperlink {

	public static void main(String[] args) {
		
				// set the system property
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				
				//open the chrome browser
				ChromeDriver driver = new ChromeDriver();
				
				// Open the URL
				driver.get("http://www.leafground.com/pages/Link.html");
				
				// Implicit wait for 10 seconds
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				// Without clicking, find the url
				String attribute = driver.findElementByXPath("(//a[@link='blue'])[2]").getAttribute("href");
				System.out.println(attribute);
				
				// check link is broken or not
				driver.findElementByXPath("//a[@href='error.html']").click();
				boolean contains = driver.getTitle().contains("404");
				System.out.println(contains);
				
	}

}
