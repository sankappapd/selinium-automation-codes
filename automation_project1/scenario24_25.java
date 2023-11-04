package automation_project1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario24_25 {
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
	public void admin() {

		// find username
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		// find password
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		// login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		List<WebElement> menus = driver.findElements(By.className("oxd-main-menu-item--name"));
		menus.get(0).click();
		WebElement ascend = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-paper-container']/div[@class='orangehrm-container']/div[@role='table']/div[@role='rowgroup']/div[@role='row']/div[2]/div[1]/i[1]"));
		Actions actions = new Actions(driver);
		actions.click(ascend).build().perform();
		WebElement optionToSelect = driver.findElement(By.xpath(
				"//div[@class='--active oxd-table-header-sort-dropdown']//span[@class='oxd-text oxd-text--span'][normalize-space()='Ascending']"));
		optionToSelect.click();

	}

	@Test(dependsOnMethods = "admin")
	public void count() {
		driver.findElement(
				By.xpath("//div[@role='columnheader']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
