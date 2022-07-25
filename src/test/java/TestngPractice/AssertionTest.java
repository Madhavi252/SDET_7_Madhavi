package TestngPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {

	@Test
	public void assertTest() {

		System.out.println("Launch the browser");

		System.out.println("Enter URL");

		System.out.println("Login page should be displayed");

		System.out.println("Enter Username");

		System.out.println("Enter password");

		String actualresult = "get Title";

		String expectedresult = "get Title";

		//Assert.assertEquals(actualresult, expectedresult);  //hard assert

		SoftAssert softAssert = new SoftAssert();	//soft assert
		softAssert.assertEquals(actualresult, expectedresult);
		
		

		System.out.println("Home page should be displayed");
		
		
		softAssert.assertAll();

	}


}











