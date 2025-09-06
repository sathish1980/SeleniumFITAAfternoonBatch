package BaiscsOfTestNg;

import org.testng.annotations.*;

public class TestNg2 {
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("AfterSuite");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest");
	}
	
	@Test
	public void Testcase4()
	{
		System.out.println("Testcase4");
	}

	
	@Test
	public void Testcase5()
	{
		System.out.println("Testcase5");
	}

}
