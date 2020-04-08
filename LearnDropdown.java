package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

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

		// Click on Create Lead
		driver.findElementByLinkText("Create Lead").click();

		// Enter the mandatory fields
		driver.findElementById("createLeadForm_companyName").sendKeys("Ciber");
		driver.findElementById("createLeadForm_firstName").sendKeys("Akila");
		driver.findElementById("createLeadForm_lastName").sendKeys("Murali");
		
		//choose dropdown
		WebElement drop = driver.findElementById("createLeadForm_dataSourceId");
		Select dd = new Select(drop);
		
		// Select by visible text [Source]
		dd.selectByVisibleText("Conference");

		//choose dropdown
		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
		Select dd1 = new Select(industry);
		
		// Select last option in industry with index
		List<WebElement> options = dd1.getOptions();
		int size = options.size();
		dd1.selectByIndex(size-1);
		
		//choose dropdown
		WebElement marketing = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dd2 = new Select(marketing);
		
		// Select by value [marketing]
		dd2.selectByValue("CATRQ_CARNDRIVER");
		
		/*
		 * // Click on submit driver.findElementByName("submitButton").click();
		 * 
		 * // Verify the title String title = driver.getTitle();
		 * System.out.println(title);
		 */

	}

}
