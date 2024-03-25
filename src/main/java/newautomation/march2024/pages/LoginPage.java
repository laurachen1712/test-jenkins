package newautomation.march2024.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public void loginWeb(String usernameText, String passwordText) {
		setText(username, usernameText);
		setText(password, passwordText);
		clickAndWait(loginBtn);
	}
	
	public void inputUsername(String usernameText) {
		setText(username, usernameText);
	}
	
	public void inputPassword(String passwordText) {
		setText(password, passwordText);
	}
	
	public void clickLoginButton() {
		clickAndWait(loginBtn);
	}
	
}
