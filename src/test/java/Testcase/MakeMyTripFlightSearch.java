package Testcase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import CommonUtils.Elements;
import DriverUtils.Browsers;
import Utils.PropertyFileHandlings;



public class MakeMyTripFlightSearch extends Browsers {
	
	
	@BeforeSuite
	public void OpentheBrowser() throws IOException
	{
		LaunchTheBrowser();
	}
	
	@BeforeTest
	public void EnterApplicationURL() throws IOException
	{
		String url = PropertyFileHandlings.ReadFile().getProperty("url");
		Elements.Open(driver,url);
	}
	
	@Test(priority=0)
	public void SearchwithValidData()
	{
		System.out.println("Search Test Case");
		test = extent.createTest("SearchWithValidValues Testcase");
		
		test.log(Status.INFO, "Close the Popup");
		test.log(Status.INFO, "select from location");
		test.log(Status.INFO, "select to location");
		test.log(Status.INFO, "select date");
		test.log(Status.INFO, "Click on Search");
		
		test.log(Status.PASS, "Testcase Passed");
		
		/*
		 * Close the Popup
		 * select from location
		 * select to location
		 * Select date
		 * Click on Search
		 * Validate the search criteria
		 */
		
	}
	@AfterSuite
	public void TearDown()
	{
		CloseTheBrowser();
	}
	
}
