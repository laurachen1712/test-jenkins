package newautomation.march2024;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebTest {
	@Test
	public void testLogin() {
		ChromeDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
		
		driver.quit();
	}
	
	@Test
	public void testLoginFailedWrongUsername() {
		ChromeDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmit");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}
	
	@Test
	public void testLoginFailedWrongPassword() {
		ChromeDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your password is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}
	
	@Test
	public void testLoginFailedWrongUsernameAndPassword() {
		ChromeDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmit");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));

		driver.quit();
	}
}
