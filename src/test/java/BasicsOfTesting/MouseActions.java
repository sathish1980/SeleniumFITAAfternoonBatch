package BasicsOfTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MouseActions {
	
	//@Test
	public void launch()
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.ebay.com/");
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.xpath("//*[@class='vl-flyout-nav__js-tab']//*[text()='Electronics']"))).perform();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Computers and tablets']")));
		
		mouse.moveToElement(browser.findElement(By.xpath("//*[text()='Computers and tablets']"))).click().perform();
	}
	
	//@Test
	public void DargandDrop() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://leafground.com/drag.xhtml");
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("form:drag"))).dragAndDrop(browser.findElement(By.id("form:drag")), browser.findElement(By.id("form:drop_content"))).perform();
		Thread.sleep(1000);
		
		mouse.moveToElement(browser.findElement(By.id("form:conpnl"))).dragAndDropBy(browser.findElement(By.id("form:conpnl")), 200, 0).perform();
		Thread.sleep(1000);
		
		mouse.moveToElement(browser.findElement(By.id("form:conpnl"))).dragAndDropBy(browser.findElement(By.id("form:conpnl")), -100, 0).perform();
		Thread.sleep(1000);
		
		mouse.moveToElement(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]"))).dragAndDropBy(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]")), 50, 0).perform();
		mouse.moveToElement(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]"))).dragAndDropBy(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]")), 50, 0).perform();
		
	}
	
	@Test
	public void remainingActions() throws InterruptedException
	{
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.facebook.com/");
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("Sathish").doubleClick().contextClick().perform();
			
	}
	
	
	

}
