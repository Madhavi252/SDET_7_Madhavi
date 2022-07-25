package TestngPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Annotation2 extends Annotation{
	

	@Parameters("USERNAME")

	@Test(groups = "smoke")
	public void test3(String uN) {
		System.out.println(uN);
		System.out.println("@test3 execution");
	}

	@Parameters("PASSWARD")
	@Test(groups = "smoke")
	public void test4(String pW) {
		System.out.println(pW);
		System.out.println("@test4 execution");
	}

}
