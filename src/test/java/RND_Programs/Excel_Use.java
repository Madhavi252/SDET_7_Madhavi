package RND_Programs;

import com.VTIGER.generic.ExcelFile;

public class Excel_Use {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		ExcelFile excelfile = new ExcelFile();
		
		String data= excelfile.readDataFromExcel("../SDET7_MADHAVI/excel.xlsx", "Sheet1", 1, 1);
		
		System.out.println(data);
	}

}
