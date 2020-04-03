package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLeadAssignment {

	public static void main(String[] args) {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		// Open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");
				
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
				
		// Clicking Login button
		driver.findElementByClassName("decorativeSubmit").click();
				
		// Click on CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		
		// Click on Leads
		driver.findElementByLinkText("Leads").click();
		
		// Click on Find Leads
		driver.findElementByLinkText("Find Leads").click();
		
		// Click on Email Tab
		driver.findElementByXPath("//span[text()='Email']").click();
		
		// Enter the email address
		driver.findElementByName("emailAddress").sendKeys("test@gmail.com");
		
		// Click Find Leads Button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Capture name of first result
		String name = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").getText();
		System.out.println(name);
		
		// Click the first captured result
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		
		// Click Duplicate Lead Button
		driver.findElementByLinkText("Duplicate Lead").click();
		
		// Verify the title
		boolean verifyTitle = driver.getTitle().contains("Duplicate Lead");
		System.out.println(verifyTitle);
		
		// Click Create Lead Button
		driver.findElementByClassName("smallSubmit").click();
		
		// Confirm duplicated lead name is same as captured name
		boolean verifyname = driver.findElementById("viewLead_firstName_sp").equals(name);
		System.out.println(verifyname);
		
		// Close the browser
		driver.close();
		
	}

}
