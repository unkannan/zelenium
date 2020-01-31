package AdvanceSelenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelReader {
	
	//Add below depdency for accessing excel   <groupId>org.apache.poi</groupId> and  <groupId>org.apache.poi</groupId>
		@Test
		public void ReadExcel() throws IOException, IllegalStateException, InvalidFormatException {
			//ExcelReadin
			InputStream inp = new FileInputStream("C:\\Data\\data.xlsx"); 
		    	Workbook wb = WorkbookFactory.create(inp);
		    
		    //Navigating to mainsheet
		    Sheet sheet = wb.getSheet("BizRuleSheet");
		    
					  String CreateFileFlag=sheet.getRow(0).getCell(0).toString();
					  String CreateFileFlag1=sheet.getRow(1).getCell(0).toString();
					  System.out.println(CreateFileFlag);
					  System.out.println(CreateFileFlag1);
				}

}
