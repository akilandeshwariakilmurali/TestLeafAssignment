package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class GmailUsingWD {

	public static void main(String[] args) {
		
				// set the system property
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				
				//open the chrome browser
				ChromeDriver driver = new ChromeDriver();
				
				// Open the URL
				driver.get("http://gmail.com");
				
				// Get the title
				String title = driver.getTitle();
				System.out.println(title);
				
				// Refresh the browser
				driver.navigate().refresh();
				
				// Close the browser
				driver.close();
	}

}
