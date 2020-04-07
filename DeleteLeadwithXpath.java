package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadwithXpath {

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
		
		// Click on Phone
		driver.findElementByXPath("//span[text()='Phone']").click();
		
		// Enter Phonenumber
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("787155");
		
		// CLick on Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		// Capture the resulting lead
		String result = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]").getText();
		System.out.println(result);
		
		// CLick first resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[1]").click();
		
		// Click DElete
		driver.findElementByXPath("//a[text()='Delete']").click();
		
		// Click on Find Leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		// Enter Lead ID
		driver.findElementByXPath("//input[@name='id']").sendKeys(result);
		
		// CLick on Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		// Confirm whether it is deleted
		String text = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
				if( text.contains("No records to display")) {
			System.out.println("Lead is successfully deleted");
		}
		
		// Close the browser
		driver.close();
		}
		
				
	}
