package newautomation.march2024;

import org.testng.annotations.Test;

import newautomation.march2024.pages.LoginPage;
import newautomation.march2024.pages.LoginPageFactory;
import newautomation.march2024.pages.ProfilePage;
import newautomation.march2024.pages.ProfilePageFactory;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

public class WebTestAfterPageFactory extends BaseWebTest {
	
	@Test
	public void testLogin() {
		
		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);
		
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
}
