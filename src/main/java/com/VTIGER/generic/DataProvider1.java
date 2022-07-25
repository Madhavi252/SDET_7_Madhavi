package com.VTIGER.generic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@Test(dataProvider = "getValue")
	public void testMMT(String src, String dest) {
		System.out.println(src+"-->"+dest);
		
	}
	
	@DataProvider
	public Object[][] getValue() {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Object[][] arr = new Object [5][2];
		
		arr[0][0] ="DEL";
		arr[0][1]="HYD";
		
		arr[1][0] ="HYD";
		arr[1][1]="BOM";
		
		arr[2][0] ="BOM";
		arr[2][1]="MAA";
		
		arr[3][0] ="DEL";
		arr[3][1]="PNQ";
		
		arr[4][0] ="HYD";
		arr[4][1]="BOM";
		
		return arr;
		
	}

}
