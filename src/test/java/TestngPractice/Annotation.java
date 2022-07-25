package TestngPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotation {
	
	@Test(groups = {"smoke","regression"})
	public void test() {
		
		System.out.println("@test execution");
	}
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void beforesuit() {
		System.out.println("before suit");
	}
	
	@AfterSuite(groups = "smoke")
	public void aftersuit() {
		System.out.println("after suit");
	}
	
	@BeforeTest(groups = {"smoke","regression"})
	public void beforetest() {
		System.out.println("before test");
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void aftertest() {
		System.out.println("after test");
	}
	
	@Parameters("browser")
	@BeforeClass(groups = "smoke")
	public void beforeclass(String browser) {
		System.out.println(browser);
		System.out.println("before class");
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void afterclass() {
		System.out.println("after class");
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void beforemethod() {
		System.out.println("before method");
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void aftermethod() {
		System.out.println("after method");
	}
	
	

}











