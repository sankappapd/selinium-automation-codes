package setup;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;

	import java.time.Duration;
	import java.util.concurrent.TimeUnit;

	public class Setpage {
	    public WebDriver driver;
	    @BeforeTest
	    public void setup (){
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	    @AfterTest
	    public void closeDriver() {
	        driver.close();
	    }

}
