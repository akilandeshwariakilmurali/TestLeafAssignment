package week1.day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Weekend1Assignment2 {

	public static void main(String[] args) throws InterruptedException {
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
		Thread.sleep(3000);
		
		// Enter First name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu");
		//driver.findElementByName("firstName").sendKeys("Babu");		
		
		// Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		
		// Click first resulting lead
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();
		
		//Verify title
		String title = driver.getTitle();
		System.out.println(title);
		
		// Click Edit button
		driver.findElementByLinkText("Edit").click();
		
		// Edit the company name
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Change the company");
		String name = driver.findElementById("updateLeadForm_companyName").getText();
		System.out.println(name);
		
		//Click on update button
		driver.findElementByName("submitButton").click();
		
		// Verify the updated name
		String verifyname = driver.findElementById("viewLead_companyName_sp").getText();
		
		System.out.println(verifyname);
		if (verifyname.contains(name)) {
			System.out.println("Name is updated properly");
		}
		
		// close the browser
		driver.close();
		
		}
				
	}
