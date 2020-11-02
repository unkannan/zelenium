package humanbizrules;

import java.io.File;

import org.junit.Test;

import ProcessMessages.ProcessFiles;
import humanbizrules.CommonFunctionforExecution;


/**
 * Unit test for simple App.
 */
public class humanbizrules 
     
{
	
	private String ResultsSheet="DataSheet";//System.getProperty("ResultsSheet");
   
	
	
	@Test
    public void HumanBizRulesValidation()
    {
		System.out.println("File Validation is in Progress");
		ProcessFiles fileProcess=new ProcessFiles();
		fileProcess.HumanFilesSendToQueue();
		
	System.out.println("File Validation is in Progress");
		try {
			File file=new File("./data.xlsx");
				CommonFunctionforExecution.ReadingExcelFileNameUpdatingACKDetailsFromDB(file.toString(),ResultsSheet);
				System.out.println("File Validation Completed"); }
		catch (Exception e) {e.printStackTrace();}
}
}
