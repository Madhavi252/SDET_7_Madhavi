package com.VTIGER.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String readDataFromExcel(String sheet, int row, int cell) throws Throwable {
		
		FileInputStream fis = new FileInputStream("../SDET7_MADHAVI/src/main/java/com/VTIGER/generic/excelUtility MMT.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		return book.getSheet(sheet).getRow(row).getCell(cell).toString();
		
	}

}
