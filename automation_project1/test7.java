package automation_project1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test7 {
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
	public void addemployee() {
		// find username
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		// find password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		// login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		List<WebElement> menus = driver.findElements(By.className("oxd-main-menu-item--name"));
		menus.get(1).click();

		driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("P");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("d");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Cancel']")).click();
	}

	@AfterTest
	public void teardown() {
		// driver.close();
	}

}