package DriverUtils;
import java.io.Externalizable;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

//import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyFileHandlings;

public class Browsers {
	
	public WebDriver driver;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	//helps to generate the logs in test report.
	public static ExtentTest test;
	
	String reportPath = System.getProperty("user.dir")+"\\Report\\Automation.html";
	
	public void LaunchTheBrowser() throws IOException
	{
		String BrowserName = PropertyFileHandlings.ReadFile().getProperty("browser");
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if (BrowserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
			{
			driver = new FirefoxDriver();
			}
		driver.manage().window().maximize();
		CreateorStartReport();
	}
	
	
	
	public void CreateorStartReport()
	{
		htmlReporter = new ExtentSparkReporter(reportPath);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	}
	
	
	public void CloseReport()
	{
		extent.flush();
	}
	
	public void CloseTheBrowser()
	{
		CloseReport();
		driver.quit();
	}
	
	/*@AfterMethod
	public void WriteInReport(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.SUCCESS) {
			String filePath = Elements.GetScreenshot(driver,result.getName());
		     test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is passed");

        }else if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is FAILED");
            String filePath = Elements.GetScreenshot(driver,result.getName());
            test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.FAIL,"Test failure : "+ result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.SKIP,"Test Method named as : "+ result.getName()+" is skipped");
        }
	}*/
	

}
