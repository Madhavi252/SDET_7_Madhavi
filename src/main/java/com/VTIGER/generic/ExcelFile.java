package com.VTIGER.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Dell
 * Description : This class is used to fetch the data from excel sheet.
 * returns the value
 *  
 */

public class ExcelFile {
	
	/**
	 * Description : This method is going to fetch the data from excel sheet.
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromExcel(String path, String sheet, int row, int cell) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IAutoconsts.excelFile);
		
		Workbook book = WorkbookFactory.create(fis);
		
		return book.getSheet(sheet).getRow(row).getCell(cell).toString();
		
	}

}
