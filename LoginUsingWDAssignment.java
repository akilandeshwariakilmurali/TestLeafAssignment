package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginUsingWDAssignment {

	public static void main(String[] args) {
		
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		// Open the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		//Enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		
		// Clicking Login button
		driver.findElementByClassName("decorativeSubmit").click();
		
		// Click on CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		
		// Click on Create Lead
		driver.findElementByLinkText("Create Lead").click();
		
		// Enter the mandatory fields
		driver.findElementById("createLeadForm_companyName").sendKeys("Ciber");
		driver.findElementById("createLeadForm_firstName").sendKeys("Akila");
		driver.findElementById("createLeadForm_lastName").sendKeys("Murali");
		
		// Click on submit
		driver.findElementByName("submitButton").click();
		
		//Verify the title
		String title = driver.getTitle();
		System.out.println(title);
		
		//Close the broswer
		driver.close();
	}

}