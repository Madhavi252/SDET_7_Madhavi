package com.VTIGER.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Dell
 * Description : This class is going to store the data from external resources.
 *
 */


public class PropertyFile 
{
	/**
	 * Description : This method is fetching the data from notepad file.
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDatafromPropfile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IAutoconsts.propertyFile);

		Properties prop = new Properties();

		prop.load(fis);

		String value=prop.getProperty(key);

		return value;

	}

}

