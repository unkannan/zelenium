package GenerateBizRuleXML.GenerateBizRuleXML;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import GenericLibraryFunctions.*;
import ModifyXMLString.ModifyXMLStringWithRules; 

public class CreateR2BizRuleMessageFile{
	static String ExcelFilePath = "C:\\Data\\data.xlsx";
	static String DataSheet="DataSheet";
	static String BizRuleFiles="c:\\Data\\HumanBizRuleFiles";//"c:\\Data\\VETBizRuleFiles";
	String FileName="c:\\Data\\R2_BizRule_Template.xml";
	
	ConvertXMLToString convertxmltoString;
	DeleteFilesFromFolder deletefiles;
	CreateFileUsingStringContent createFile;
	ModifyXMLStringWithRules ApplyRuleLogic;
	
	
	@Test
	public void CreateBizRuleMessageFiles() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String CreateFileFlag=null;
		String xmlTagColumn=null;
		convertxmltoString=new ConvertXMLToString();
		deletefiles=new DeleteFilesFromFolder();
		createFile=new CreateFileUsingStringContent();
		ApplyRuleLogic=new ModifyXMLStringWithRules();
		
		//deleting all existing files
		deletefiles.DeleteExistingBizRuleFiles(BizRuleFiles);
		
				    //ExcelReadin
					InputStream inp = new FileInputStream(ExcelFilePath); 
				    Workbook wb = WorkbookFactory.create(inp);
				     
		 //Navigating to mainsheet
		 Sheet sheet = wb.getSheet(DataSheet);
				    
			for(int j=1;j<sheet.getLastRowNum()+1;j++){
					    	 
				//Reading the Flag for creating file
				try{
					CreateFileFlag=sheet.getRow(j).getCell(0).toString();
				}catch(Exception e){
					CreateFileFlag="N";}
					    	 	
					if(CreateFileFlag.equals("Y")) {
					//Reading the excel for the Tags and values which need to be modified
					try{
						xmlTagColumn=sheet.getRow(j).getCell(11).toString();
						}catch(Exception e) {
						  xmlTagColumn="";}
					    	 		 
					if(xmlTagColumn!=""){
					String XLFileName=sheet.getRow(j).getCell(13).toString();//filename and batch number
					System.out.println(FileName+" IS IN PROGRESS");	
					
									//Reading the template and storing in a string
									String BizRuleXMLFileContent = convertxmltoString.ReadXMLTemplate(FileName);		
									//String newXmlFileContent=modifyXML(xmlTagColumn1,Value,fileName);
					
					//Modify the xml tag values and storing in a string to create the file - This is the main core/crux
					BizRuleXMLFileContent=ApplyRuleLogic.CreateNewBizRuleFileXMLContent(BizRuleXMLFileContent,xmlTagColumn);	
					    	 									  
									//Changing the batchnumber in xml
								   //BizRuleXMLFileContent=ChangeBatchNumber(BizRuleXMLFileContent,FileName);
					
										//Creating a new xml file
					                      createFile.CreateBizRuleFile(BizRuleFiles,BizRuleXMLFileContent,XLFileName+".xml");
					    	 			}   
					    	 		}
						  	}
	}
}
