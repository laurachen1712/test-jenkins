package newautomation.march2024.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageFactory extends BasePageFactory {
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	public LoginPageFactory(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	public void loginWeb(String usernameText, String passwordText) {
		username.sendKeys(usernameText);
		password.sendKeys(passwordText);
		loginBtn.click();
	}
	
	public void inputUsername(String usernameText) {
		username.sendKeys(usernameText);
	}
	
	public void inputPassword(String passwordText) {
		password.sendKeys(passwordText);
	}
	
	public void clickLoginButton() {
		loginBtn.click();
	}
	
}
