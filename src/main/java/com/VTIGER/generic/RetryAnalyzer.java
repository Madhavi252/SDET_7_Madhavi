package com.VTIGER.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int count = 0;
	int rerun = 3;
	
	public boolean retry(ITestResult result) {
		
		if(count<rerun) {
		
		count++;
		return true;
		
		}
		
		return false;
	}
	

}
