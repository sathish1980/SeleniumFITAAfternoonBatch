package BasicsOfTesting;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardActionsAssignment {

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
		public void RobotKeyboardACtions() throws InterruptedException, AWTException, IOException
		{
			WebDriver browser = new ChromeDriver();
			browser.manage().window().maximize();
			browser.get("https://www.facebook.com/");
			
			Actions mouse = new Actions(browser);
			mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").doubleClick().contextClick().perform();
			Takescreenshotvalidation(browser,"Search");
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(2000);
			Takescreenshotvalidation(browser,"last");
		}
	
	
	public void Takescreenshotvalidation(WebDriver browser,String filename) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot)browser;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File(System.getProperty("user.dir")+"//Screenshot//"+filename+".png");
		FileUtils.copyFile(sourceFile, DestinationFile);
		
	}
	
	
}
