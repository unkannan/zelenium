package vich_file_creation.vich_file_creation;

<<<<<<< HEAD
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Before;
import org.junit.Test;
//import eu.europa.ema.phv.adr.messaging.tests.FunctionalTestCases;
import org.xml.sax.SAXException;

public class createfiles {
	final String ExcelFilePath = "Files/Templates/createfilesfromxpath_A.xlsx";
	//final String VICH_TestFile_AllFields = "Files/Templates/A11_Raname_valid.xml";
	final String VICH_TestFile_AllFields = "Files/Templates/VICH_File_With_All_Elements.xml";
	
	final String NullFlavorsTemplate = "Files/Templates/NullFlavorsTemplate.xml";
	//final String validtemplatefile = "Files/Templates/A11_Raname_valid.xml";
	final String RenameTestFilesInDir="Files/bizrulefiles";
	XpathSupport createFile=null; 
	RenameFIle renamefileObj=null;
	
	
	@Before
	public void GetReadyBeforecreation() throws IOException {
		createFile = new XpathSupport();
		renamefileObj=new RenameFIle();
		
	}
	
	//@Test
	public void CreateTestDataFilesFromExcel() throws IOException {
		//String sheet="createvichtestfiles";
		int sheetnumber=0;
		
		createFile.CreatingXMLFilesFromGivenSheet(sheetnumber,ExcelFilePath,VICH_TestFile_AllFields,NullFlavorsTemplate);
	}
	
	@Test
	public void renameFile() throws IOException, XPathExpressionException, ParserConfigurationException, SAXException, TransformerException {
		//String sheet="createvichtestfiles";
		int sheetnumber=0;
		
		renamefileObj.renameExistingFilesinGivenFolder(sheetnumber,ExcelFilePath,RenameTestFilesInDir);
=======
import Lib.ExcelReader;

public class createfiles {
	static String ExcelFilePath = "Files/MandatoryRuleFile.xlsx";
	static String validtemplatefile = "Files/VICH_TestFile.xml";

	public static void main(String args[]) {
		ExcelReader xlreader=new ExcelReader();
		
		System.out.println(xlreader.getcolumnindex(ExcelFilePath,"FILENAME"));
		XpathSupport createFile = new XpathSupport();
	
		System.out.println("datarowcount="+xlreader.getDataRowCount(ExcelFilePath));
		 
			for (int j = 1; j <= xlreader.getDataRowCount(ExcelFilePath); j++) {
				System.out.println("flag="+xlreader.getcellvalue(ExcelFilePath,j,"flag"));
				if (xlreader.getcellvalue(ExcelFilePath,j,"flag").equalsIgnoreCase("Y")
						|| xlreader.getcellvalue(ExcelFilePath,j,"flag") != null) {
					System.out.println("jasonString="+xlreader.getcellvalue(ExcelFilePath,j,"XPATH"));
					String jasonString = xlreader.getcellvalue(ExcelFilePath,j,"XPATH"); 
					System.out.println("newfilename="+xlreader.getcellvalue(ExcelFilePath,j,"FILENAME").toString());
					String newfilename = xlreader.getcellvalue(ExcelFilePath,j,"FILENAME");
					try {
						createFile.createfilefromtemplate1(validtemplatefile, jasonString,
								"Files/bizrulefilesfldr/" + newfilename + ".xml");
					} catch (Exception e) {
						System.out.println("Error in creating file");
						e.printStackTrace();
					}
				}
			}
>>>>>>> adfbf84d77190a22dcd4990f1e37fb68781bf2b7
	}
}	 
