package humanbizrules;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import DBQueryResults.DBQueryResult;

public class CommonFunctionforExecution {
	static String BizRuleFiles="c:\\Data\\HumanBizRuleFiles";//"c:\\Data\\VETBizRuleFiles";
	String FileName="c:\\Data\\R2_BizRule_Template.xml";
	
	public static String HumanDBQueryResultsProvisionFileName(String FileName) {
		DBQueryResult dBQueryResult = new DBQueryResult();
		return dBQueryResult.HumanDBqueryResultProvisionFileName(FileName);
	}
	
	
	  public static void ReadingExcelFileNameUpdatingACKDetailsFromDB(String ExcelFilePath,String ResultsSheet) throws EncryptedDocumentException, InvalidFormatException, IOException {
			// Opening the Data.xlsx
			InputStream inp = new FileInputStream(ExcelFilePath);
			Workbook wb = WorkbookFactory.create(inp);
			// Navigating to mainsheet
			Sheet MainSheetxl = wb.getSheet(ResultsSheet);
			int cell=9;
			String ExpectedFileName=null;
			for(int row=1;row<MainSheetxl.getLastRowNum();row++){
				String Flag=null;
								try{
				Flag=MainSheetxl.getRow(row).getCell(0).getStringCellValue();
									}catch(Exception e) {Flag="N";}
				//Reading file names from first column
					if(Flag.equalsIgnoreCase("Y")) {					
						try {
							ExpectedFileName=MainSheetxl.getRow(row).getCell(cell).getStringCellValue();
							}catch(NullPointerException e){ExpectedFileName=null;}
				
				if(ExpectedFileName!=null) {
				String DBACKQueryResults=HumanDBQueryResultsProvisionFileName(ExpectedFileName);

						//Updating the db values in excel next cell of the fileName
						MainSheetxl.getRow(row).createCell(12).setCellValue(DBACKQueryResults);
						FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
						wb.write(fileOut);
						fileOut.close();
					}
				}
			}
		}
	  
	  
}
	  
