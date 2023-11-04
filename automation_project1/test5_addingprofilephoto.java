package automation_project1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test5_addingprofilephoto {
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

		String photopath = ("C:\\Users\\SANKAPPA-PC\\eclipse-workspace\\selenium\\projectssel\\src\\test\\java\\pp\\New Doc 3-min.jpg");
		// WebElement fileInput = driver.findElement(By.xpath("//i[@class='oxd-icon
		// bi-plus']"));
		// fileInput.sendKeys("photopath");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus']"));

		// Wait for the element to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys("New Doc 3-min.jpg");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
