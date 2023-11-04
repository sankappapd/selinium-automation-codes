package automation_project1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenasrio22 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void help() {
		// find username
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		// find password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		// login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		List<WebElement> menus = driver.findElements(By.className("oxd-main-menu-item--name"));
		menus.get(1).click();
		WebElement configdropdown = driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-chevron-down\"]"));
		;
		Actions actions = new Actions(driver);
		actions.click(configdropdown).build().perform();
		WebElement optionToSelect = driver.findElement(By.xpath("//a[normalize-space()='Reporting Methods']"));
		optionToSelect.click();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-question-lg']")).click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
