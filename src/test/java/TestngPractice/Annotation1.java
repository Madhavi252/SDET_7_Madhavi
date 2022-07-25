package TestngPractice;

import org.testng.annotations.Test;

public class Annotation1 {

	@Test(groups = "smoke")
	public void test1() {

		System.out.println("@test1 execution");
	}

	@Test(groups = "integration")
	public void test2() {
		System.out.println("@test2 execution");
	}

}
