package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnList {

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
		List<WebElement> trainNames = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		
		List<String> tn = new ArrayList<String>();
		for (WebElement eachTrain : trainNames) {
			String train = eachTrain.getText();
			tn.add(train);
		}
		// Sorting the list
		Collections.sort(tn);
		// Printing the list
		for (int i = 0; i < tn.size(); i++) {
			System.out.println(tn.get(i));

		}
	}
}
