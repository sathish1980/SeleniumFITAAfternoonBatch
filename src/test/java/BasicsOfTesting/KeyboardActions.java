package BasicsOfTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardActions {

	//@Test
	public void KeyboardACtions() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").perform();
		mouse.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
	}
	
	@Test
		public void RobotKeyboardACtions() throws InterruptedException, AWTException
		{
			WebDriver browser = new ChromeDriver();
			browser.manage().window().maximize();
			browser.get("https://www.facebook.com/");
			
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").perform();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
		}
	
	
}
