package BaiscsOfTestNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class TestNG1 {
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass(alwaysRun=true)
	public void AfterClass()
	{
		System.out.println("After Class");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethod()
	{
		System.out.println("Before MEthod");
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void AfterMethod()
	{
		System.out.println("After MEthod");
	}
	
	
	@Test(priority=2,timeOut=60,groups="Sanity",dataProvider="dataproviderName")
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
	@Test(priority=1,groups="SIT")
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}

	
	@Test(priority=0,invocationCount=4,invocationTimeOut=60,groups="Sanity")
	public void Testcase3() throws InterruptedException
	{
		System.out.println("Testcase3");
		//Thread.sleep(100);
	}
}
