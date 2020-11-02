package vich_database_validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import com.azure.cosmos.vich.dbresults.validation.SafetyReportCheckInCosmosDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UpdateExcelwithCosmosResults {
	 //final String ExcelFilePath = "C:\\Users\\kannanu\\OneDrive\\VICH\\MandatoryRuleFile.xlsx";
//	 final String ExcelFilePath = "C:\\Users\\kannanu\\Repo\\adr-vet-tests\\src\\test\\resources\\emaadr\\vich\\adr-vich-bizrule-tests.xlsx";
	final String ExcelFilePath = "Files/Templates/createfilesfromxpath_A.xlsx";
	final String ackFilePath= "Files/acks/";
	    
	    InputStream inp =null;
		Workbook wb =null;
		Sheet sheet=null;
		final int filename = 10;
		final int flagcheck = 0;
		final int queryResultsCellValue=11;
		SafetyReportCheckInCosmosDB updateTestResults=null;
		
		@Before
		public void pre_requisites() throws IOException {
					inp = new FileInputStream(ExcelFilePath);
					wb = new XSSFWorkbook(inp);
					updateTestResults=new SafetyReportCheckInCosmosDB();
		}
		
		//@Test
	    public void vich_dbdatavalidation() throws IOException {
	         
			sheet = wb.getSheetAt(0);
			
			for (int j = 1; j < 150 - 1; j++) {
				try {
				if (sheet.getRow(j).getCell(flagcheck).toString().equalsIgnoreCase("y")) {	
					String newfilename = sheet.getRow(j).getCell(filename).getStringCellValue();

					 if(newfilename.contains(".xml")) {
						 newfilename=newfilename.substring(0,newfilename.length()-4);
					 }
					 		System.out.println(newfilename);
					 		String results=updateTestResults.SafetyReportValidationCheckInDB(newfilename);

					 				//String testStr=testresultsupdate.ReadJason(newfilename);
					 				//System.out.println(testStr);	
					 			
		    				Cell newpath = sheet.getRow(j).createCell(queryResultsCellValue);
		    				newpath.setCellValue(results);

		    				 FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
		    	        wb.write(fileOut);
		    	        fileOut.close();
			            }
				}
		    			catch (Exception e1) {
		    				FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
			    	        wb.write(fileOut);
			    	        fileOut.close();
		    			}
				}	
			}

		@Test
	    public void vich_ackValidation() throws IOException {
			String results=null;
			sheet = wb.getSheetAt(0);
			
			for (int j = 1; j < 200 - 1; j++) {
				try {
				if (sheet.getRow(j).getCell(flagcheck).toString().equalsIgnoreCase("y")) {	
					String newfilename = sheet.getRow(j).getCell(filename).getStringCellValue();

					 if(newfilename.contains(".xml")) {
						 newfilename=newfilename.substring(0,newfilename.length()-4);
					 }
					 
					     String ActualFileName=updateTestResults.SearchForFile(ackFilePath,newfilename);
					     
					     ActualFileName=ackFilePath+ActualFileName;
					     if(ActualFileName!=null) 
					    	 results=updateTestResults.ackValidation(ActualFileName);
					    	 
		    				Cell newpath = sheet.getRow(j).createCell(queryResultsCellValue);
		    				newpath.setCellValue(results);

		    				 FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
		    	        wb.write(fileOut);
		    	        fileOut.close();
			            }
				}
		    			catch (Exception e1) {
		    				FileOutputStream fileOut = new FileOutputStream(ExcelFilePath);
			    	        wb.write(fileOut);
			    	        fileOut.close();
		    			}
				}	
			}
}
