package week3.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {

	public static void main(String[] args) throws InterruptedException {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");

		// Enter the password
		driver.findElementById("password").sendKeys("crmsfa");

		// Clicking Login button
		driver.findElementByClassName("decorativeSubmit").click();

		// Click on CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();

		// Click on Leads
		driver.findElementByLinkText("Leads").click();

		// Click on Merge Leads
		driver.findElementByLinkText("Merge Leads").click();

		// Click From LEad image
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();

		// Get all window handles
		Set<String> allWin = driver.getWindowHandles();

		// Add the complete set to a list
		List<String> list = new ArrayList<String>(allWin);

		// Get first window
		String first = list.get(0);

		// Get the second window
		String second = list.get(1);

		// Switch To window
		driver.switchTo().window(second);

		// Enter name
		driver.findElementByName("firstName").sendKeys("frd");

		// Click find LEads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(3000);

		// CLick first resulting lead
		WebElement id = driver.findElementByXPath("(//a[@class='linktext'])[1]");

		String idnum = id.getText();
		id.click();

		// Switch to Main window
		driver.switchTo().window(first);

		// Click To Lead image
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		
		// Get all window handles
		Set<String> allWind = driver.getWindowHandles();

		// Add the complete set to a list
		List<String> lst = new ArrayList<String>(allWind);

		// Get first window
		String firstw = lst.get(0);

		// Get the second window
		String secondw = lst.get(1);

		// Switch To window
		driver.switchTo().window(secondw);
		
		// Enter name
		driver.findElementByName("firstName").sendKeys("Babu");

		// Click find LEads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);

		// CLick first resulting lead
		driver.findElementByXPath("(//a[@class='linktext'])[1]").click();

		// Switch to Main window
		driver.switchTo().window(firstw);

		// Click Merge button
		driver.findElementByClassName("buttonDangerous").click();

		// Switch to Alert
		Alert alert = driver.switchTo().alert();

		// Accept alert
		alert.accept();

		// Click on Find Leads
		driver.findElementByLinkText("Find Leads").click();

		// Enter Lead id
		driver.findElementByName("id").sendKeys(idnum);

		// Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(3000);

		// Confirm whether it is deleted
		String text = driver.findElementByClassName("x-paging-info").getText();
		if (text.contains("No records to display")) {
			System.out.println("Lead is successfully merged, hence from lead is not available");
		}
		
		// Close the browser
		driver.quit();

	}

}
