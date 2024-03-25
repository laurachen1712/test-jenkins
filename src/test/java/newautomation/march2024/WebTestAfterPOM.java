package newautomation.march2024;

import org.testng.annotations.Test;

import newautomation.march2024.pages.LoginPage;
import newautomation.march2024.pages.ProfilePage;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;

public class WebTestAfterPOM extends BaseWebTestHeadless {
	
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	@Test
	public void testLogin() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginFailedWrongUsername() {
		String username = "tomsmit";
		String password = "SuperSecretPassword!";
		
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginFailedWrongPassword() {
		String username = "tomsmith";
		String password = "SuperSecretPassword";
		
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "Your password is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testLoginFailedWrongUsernameAndPassword() {
		String username = "tomsmit";
		String password = "SuperSecretPassword";
		
		loginPage.loginWeb(username, password);
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
