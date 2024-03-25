package newautomation.march2024;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseWebTest {
//	ChromeDriver driver;
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver.set(new ChromeDriver(options));
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
//		driver = new ChromeDriver(options);
		driver.get().manage().window().maximize();
		driver.get().get("https://the-internet.herokuapp.com/login");
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.get().quit();
//	}
}
