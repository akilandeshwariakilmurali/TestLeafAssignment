package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		// set the system property
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// open the chrome browser
		ChromeDriver driver = new ChromeDriver();

		// Open the URL
		driver.get("http://www.leafground.com/pages/table.html");

		// Implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Find the table
		WebElement table = driver.findElementById("table_id");
		
		// Number of rows
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		
		// Pick second row from the list
		WebElement secondRow = allRows.get(2);
		
		// Number of Columns
		List<WebElement> allColumns = secondRow.findElements(By.tagName("td"));
		
		// Total number of rows
		allRows.size();
		
		// Total number of columns
		allColumns.size();
		
		//  Pick second column from second row
		WebElement secondColumn = allColumns.get(1);

		// Retrieve the text
		String text = secondColumn.getText();
		System.out.println(text);

	}
}

