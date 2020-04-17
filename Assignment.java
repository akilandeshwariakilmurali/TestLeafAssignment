package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {

		// Set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// Open the Chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://dev92474.service-now.com/");

		// Implicitly wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navigate to frame
		driver.switchTo().frame("gsft_main");

		// Enter username
		driver.findElementById("user_name").sendKeys("admin");

		// Enter Password
		driver.findElementById("user_password").sendKeys("India@123");

		// Click Login button
		driver.findElementById("sysverb_login").click();
		Thread.sleep(3000);
		
		// Enter in navigation filter
		driver.findElementById("filter").sendKeys("Incident");

		// Click create new
		driver.findElementByXPath("//div[text()='Create New']").click();
		Thread.sleep(3000);

		// Navigate to frame
		driver.switchTo().frame("gsft_main");

		// GEt the value of number
		WebElement number = driver.findElementById("incident.number");

		// Incident number
		String incnumber = number.getAttribute("value");

		// Click search icon
		driver.findElementById("lookup.incident.caller_id").click();

		// Navigate to window

		Set<String> allWin = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allWin);
		String secWin = list.get(1);

		driver.switchTo().window(secWin);

		// Click first value
		driver.findElementByClassName("glide_ref_item_link").click();

		// Navigate back to main window
		String firstWin = list.get(0);
		driver.switchTo().window(firstWin);

		// Select category
		WebElement category = driver.findElementById("incident.category");

		Select ele = new Select(category);
		ele.selectByValue("software");

		// Select subcategory
		WebElement subcategory = driver.findElementById("incident.subcategory");

		Select sc = new Select(subcategory);
		sc.selectByValue("email");

		// Select contact type
		WebElement contacttype = driver.findElementById("incident.contact_type");

		Select ct = new Select(contacttype);
		ct.selectByVisibleText("Walk-in");

		// Select state
		WebElement state = driver.findElementById("incident.state");

		Select s = new Select(state);
		s.selectByValue("2");

		// Select urgency

		WebElement urgency = driver.findElementById("incident.urgency");

		Select u = new Select(urgency);
		u.selectByValue("1");

		// click on assignment group
		driver.findElementById("lookup.incident.assignment_group").click();

		// Navigate to new window
		Set<String> allWin2 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(allWin2);
		String secWin2 = list2.get(1);

		driver.switchTo().window(secWin2);

		// Getting the list of items
		List<WebElement> group = driver.findElementsByClassName("glide_ref_item_link");
		
		// Total number of items
		int size = group.size();
		
		// NAvigating to last item
		WebElement assignmentgroup = group.get(size-1);
		assignmentgroup.click();
		
		// Navigate back to main window
		String firstWin2 = list2.get(0);
		driver.switchTo().window(firstWin2);
		
		// Enter short description
		driver.findElementById("incident.short_description").sendKeys("Creating Incident for the Purpose of Management");
		
		// Click submit
		driver.findElementById("sysverb_insert").click();
		
		// Enter the created incident number
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input)[1]").sendKeys(incnumber, Keys.ENTER);
		Thread.sleep(3000);
		
		// Click the incident
		driver.findElementByClassName("linked formlink").click();
		Thread.sleep(3000);
		
		// Verify the number
		String verifyinc = driver.findElementById("incident.number").getAttribute("value");
		if(incnumber.equals(verifyinc)) {
			System.out.println("Number is same");
		}
		
		// Update the impact
		WebElement impact = driver.findElementById("incident.impact");

		Select i = new Select(impact);
		i.selectByValue("1");
		
		// Enter description
		driver.findElementById("incident.description").sendKeys("Successfully created an Incident");
		
		// Enter worknotes
		driver.findElementById("activity-stream-textarea").sendKeys("Done Right");
		
		// Click update
		driver.findElementById("sysverb_update").click();
		
		//Come out of frame
		driver.switchTo().defaultContent();
		
		// Click logout
		driver.findElementByXPath("//span[text()='System Administrator']").click();
		
		driver.findElementByXPath("//a[text()='Logout']").click();
		
		// Close the browser
		driver.close();
	}

}
