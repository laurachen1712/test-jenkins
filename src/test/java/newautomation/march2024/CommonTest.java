package newautomation.march2024;

import org.testng.annotations.Test;

import newautomation.march2024.pages.CommonPage;
import newautomation.march2024.utils.TestUtility;

public class CommonTest extends BaseWebTest {
	
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Test
	public void testSwitching() {
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://facebook.com");
		commonPage.openNewWindow();
		commonPage.switchWindow(2);
		commonPage.openUrl("https://twitter.com");
		TestUtility.hardWait(3);
	}
	
}
