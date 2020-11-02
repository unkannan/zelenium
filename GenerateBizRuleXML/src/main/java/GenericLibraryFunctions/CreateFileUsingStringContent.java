package GenericLibraryFunctions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFileUsingStringContent {
	public void CreateBizRuleFile(String DestFolder,String xml2String,String newFileName) throws IOException {
		 File file = new File(DestFolder+"//"+newFileName);
		 file.createNewFile();
		 System.out.println(file.getName()+ " file created");
		
		  FileWriter fw = new FileWriter(file);
		  		fw.write(xml2String);
		  				fw.close();
	   	    }
}
