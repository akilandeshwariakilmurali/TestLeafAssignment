package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Project {

	public static void main(String[] args) throws InterruptedException {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("https://dev28463.service-now.com/");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navigate to frame
		driver.switchTo().frame("gsft_main");

		// Enter username
		driver.findElementById("user_name").sendKeys("admin");

		// Enter Password
		driver.findElementById("user_password").sendKeys("yX1wLBuoGTm2");

		// Click Login button
		driver.findElementById("sysverb_login").click();
		Th

		// Enter in navigation filter
		driver.findElementById("filter").sendKeys("Change");
		Thread.sleep(10000);

		// Click create new
		driver.findElementByXPath("//div[text()='Create New']").click();
		Thread.sleep(3000);

		// Navigate to frame
		driver.switchTo().frame("gsft_main");

		// Click the link
		driver.findElement(By.linkText("Normal: Changes without predefined plans require approval and/or CAB authorization.")).click();;
		
		// GEt the change request number
		WebElement number = driver.findElement(By.id("change_request.number"));
		
		// Change number
		String changenumber = number.getAttribute("value");
		Thread.sleep(3000);
		
		// Enter short description
		driver.findElementById("change_request.short_description").sendKeys("Creating CR");
		
		// Click submit
		driver.findElementById("sysverb_insert").click();
		
		// Enter the created CR number
		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input)[1]").sendKeys(changenumber, Keys.ENTER);
		Thread.sleep(3000);
		
		// Click the link
		driver.findElementByClassName("linked formlink").click();
		Thread.sleep(3000);
		
		// Verify the number
		String verifychn = driver.findElementById("change_request.number").getAttribute("value");
		if(changenumber.equals(verifychn)) {
			System.out.println("Number is same");
		}
		
		// Update state as Assess
		WebElement state = driver.findElement(By.id("change_request.state"));
		
		Select sel = new Select(state);
		sel.selectByVisibleText("Assess");
		
		// Click search icon
		driver.findElement(By.id("lookup.change_request.assigned_to")).click();

		// Navigate to window

		Set<String> allWin = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allWin);
		String secWin = list.get(1);

		driver.switchTo().window(secWin);

		driver.findElementByXPath("//span[text()='Press Enter from within the input to submit the search.']/following::input)[1]").sendKeys("ITIL", Keys.ENTER);
		Thread.sleep(3000);
		
		// Click first value
		driver.findElement(By.className("glide_ref_item_link")).click();
		Thread.sleep(3000);
		
		// Navigate back to main window
		String firstWin = list.get(0);
		driver.switchTo().window(firstWin);
		Thread.sleep(3000);
		
		// Click search icon of assignment group
				driver.findElement(By.id("lookup.change_request.assignment_group")).click();

		// Navigate to window

		Set<String> allWin1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(allWin1);
		String secWin1 = list1.get(1);

		driver.switchTo().window(secWin1);
				
		// Click first value
		driver.findElement(By.xpath("//a[text()='Application Development']")).click();
		Thread.sleep(3000);
			
		// Navigate back to main window
		String firstWin1 = list.get(0);
		driver.switchTo().window(firstWin1);
		Thread.sleep(3000);
		
		// Click on update
		driver.findElement(By.id("sysverb_update")).click();
		
		// Close the browser
		driver.close();
	}

}
