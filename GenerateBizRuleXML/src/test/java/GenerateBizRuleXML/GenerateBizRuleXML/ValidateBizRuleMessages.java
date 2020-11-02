package GenerateBizRuleXML.GenerateBizRuleXML;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import DBQueryResults.DBQueryResult;

 

public class ValidateBizRuleMessages {
	static String ExcelFilePath = "C:\\Data\\data.xlsx";
	static String DataSheet="DataSheet";
	static String BizRuleFiles="c:\\Data\\HumanBizRuleFiles";//"c:\\Data\\VETBizRuleFiles";
	String FileName="c:\\Data\\R2_BizRule_Template.xml";
	
	public static String HumanDBQueryResultsProvisionFileName(String FileName) {
		DBQueryResult dBQueryResult = new DBQueryResult();
		return dBQueryResult.HumanDBqueryResultProvisionFileName(FileName);
	}
	
	@Test
	  public void ReadingExcelFileNameUpdatingACKDetailsFromDB() throws EncryptedDocumentException, InvalidFormatException, IOException {
			// Opening the Data.xlsx
			InputStream inp = new FileInputStream(ExcelFilePath);
			Workbook wb = WorkbookFactory.create(inp);
			// Navigating to mainsheet
			Sheet MainSheetxl = wb.getSheet(DataSheet);
			int cell=12;
			String ExpectedFileName=null;
			for(int row=0;row<MainSheetxl.getLastRowNum();row++){
				
				//Reading file names from first column
				try {
				ExpectedFileName=MainSheetxl.getRow(row).getCell(cell).getStringCellValue();
				}catch(NullPointerException e){
					ExpectedFileName=null;
				}
				
				if(ExpectedFileName!=null) {
				String DBACKQueryResults=HumanDBQueryResultsProvisionFileName(ExpectedFileName);
					
					//Updating the db values in excel next cell of the fileName
						MainSheetxl.getRow(row).createCell(25).setCellValue(DBACKQueryResults);
						FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
						wb.write(fileOut);
						fileOut.close();
			 }
			}
		}
}
