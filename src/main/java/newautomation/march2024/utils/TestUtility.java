package newautomation.march2024.utils;

public class TestUtility {
	
	public static void hardWait(int second) {
		try {
			Thread.sleep(1000 * second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
