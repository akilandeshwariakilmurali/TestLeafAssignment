package week3.day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnSet {

	public static void main(String[] args) {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");

		
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Get all the Train Names  
		List<WebElement> trainNames = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][1]");
		
		Set<String> tn = new HashSet<String>();
		for (WebElement eachTrain : trainNames) {
			String train = eachTrain.getText();
			tn.add(train);
		}
		
		System.out.println(tn);
		
		// Confirm no duplicates
		if(trainNames.size() == tn.size()) {
			System.out.println("No duplicates");
		}
	}

}
