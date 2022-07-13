package com.VTIGER.generic;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;


/**
 * @author Dell
 * Description : This class is going to store Fake Data which is required for
 *  Test Execution.
 * 
 */
public class FakeData {
	
	//Creating an object for faker class
	Faker faker = new Faker();
	
	/**
	 * @return 
	 * @description : This method is going to generate random firstname.
	 */
	public String firstName() {
		
		return faker.name().firstName();
	}
	
	/**
	 * Description : This method is going to generate random lastname.
	 * 
	 * @return
	 */
	public String lastName() {
		
		return faker.name().lastName();
	}
	
	/**
	 * Description : This method is going to generate random name.
	 * 
	 * @return
	 */
	public  String name() {
		
		return faker.name().name();
	}
	
	
	/**
	 * Description : This method is going to generate random company name.
	 * 
	 * @return
	 */	
	public String industryName() {
		
		return faker.company().name();
	}
	
}


















