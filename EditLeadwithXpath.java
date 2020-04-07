package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadwithXpath {

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
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
				
		//Enter the password
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
				
		// Clicking Login button
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
				
		// Click on CRM/SFA
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
		
		// Click on Leads
		driver.findElementByXPath("//a[text()='Leads']").click();
		
		// Click on Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
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
		driver.findElementByXPath("//a[text()='Edit']").click();
		
		// Edit the company name
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").clear();
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys("Change the company");
		String name = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").getText();
		System.out.println(name);
		
		//Click on update button
		driver.findElementByXPath("//input[@name='submitButton']").click();
		
		// Verify the updated name
		String verifyname = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		
		System.out.println(verifyname);
		if (verifyname.contains(name)) {
			System.out.println("Name is updated properly");
		}
		
		// close the browser
		driver.close();
		
		}
				
	}
