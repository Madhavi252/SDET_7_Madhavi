package TestngPractice;

import org.testng.annotations.Test;

public class Priority {
	
	@Test(invocationCount = 5)
	public void bysimcard() {
		System.out.println("buy sim card");
	}
	
	@Test(enabled = true)
	public void activatesimcard() {
		System.out.println("activate sim card");
	}
	
	@Test(dependsOnMethods = "activatesimcard")
	public void cutomersupport() {
		System.out.println("customer support");
	}

}
