package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {

		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://myntra.com");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Maximize
		driver.manage().window().maximize();

		// Locate the webelement
		WebElement Women = driver.findElementByXPath("//a[text()='Women']");

		// Mouse hover on Women
		Actions act = new Actions(driver);
		act.moveToElement(Women).perform();
		Thread.sleep(3000);

		// Click Jackets & Coats
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();

		// Total count of items
		WebElement count = driver.findElementByXPath("//span[@class='title-count']");
		String tc = count.getText();
		String total = tc.replaceAll("\\D", "");
		int totcount = Integer.parseInt(total);
		System.out.println(totcount);

		// CAtegories
		WebElement num1 = driver.findElementByXPath("//span[@class='categories-num']");
		String no1 = num1.getText();
		String s = no1.substring(1, 5);
		int s1 = Integer.parseInt(s);

		WebElement num2 = driver.findElementByXPath("(//span[@class='categories-num'])[2]");
		String no2 = num2.getText();
		String s2 = no2.substring(1, 4);
		int s3 = Integer.parseInt(s2);

		int categorytotal = s1 + s3;
		System.out.println(categorytotal);

		// validate sum of category count matches
		if (totcount == categorytotal) {
			System.out.println("Category count matches");
		}

		// Check Coats
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();

		// Click more
		driver.findElementByXPath("//div[@class='brand-more']").click();

		// Enter MANGO in text box
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("Mango");

		// Click checkbox
		driver.findElementByXPath("//label[@class=' common-customCheckbox']").click();

		// Close it
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		Thread.sleep(3000);

		// Confirm all belongs to brand Mango
		List<WebElement> Mango = driver.findElementsByXPath("//h3[@class='product-brand']");
		for (WebElement each : Mango) {
			String ch = each.getText();
			if (ch.equals("MANGO")) {
				System.out.println("All belongs to brand mango");
			}
		}
		// Sort by Better discount
		driver.findElementByXPath("//span[text()='Recommended']").click();
		driver.findElementByXPath("(//label[@class='sort-label '])[text()='Better Discount']").click();
		Thread.sleep(3000);
		//driver.findElementByXPath("//div[@class='filter-summary-selectedFilterContainer']").click();

		// Price of first displayed item
		List<WebElement> price = driver.findElementsByClassName("product-discountedPrice");
		String firstPrice = price.get(0).getText();
		System.out.println("Price of first coat is " + firstPrice);

		// Mouse hover on size of first item
		WebElement first = driver.findElementByXPath("//span[@class='product-discountedPrice']");
		WebElement firstSize = driver.findElementByXPath("//span[@class='product-sizeInventoryPresent']");
		act.moveToElement(first).moveToElement(firstSize).perform();

		// CLick on wishlist
		driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']").click();
		System.out.println(driver.getTitle());
		
		// close the browser
		driver.close();
	}

}
