package newautomation.march2024;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WebTest2 {
	
	@Test
	public void testDropdown() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/dropdown");
		
		driver.findElement(By.xpath("//select[@id='dropdown']")).click();
		driver.findElement(By.xpath("//*[contains((text()), 'Option 2')]")).click();
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		List<WebElement> actualList = select.getOptions();
		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Please select an option");
		expectedList.add("Option 1");
		expectedList.add("Option 2");
		
		System.out.println("The dropdown options are:");
		
		for(int i = 0; i < 3; i++) {

    		Assert.assertEquals(actualList.get(i).getText(), expectedList.get(i));

//    		System.out.println("Actual : " + actualList.get(i).getText());
//    		System.out.println("Expected : " + expectedList.get(i));
		}

		
		driver.quit();
	}
}
