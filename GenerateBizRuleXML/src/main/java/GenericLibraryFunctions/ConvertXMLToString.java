package GenericLibraryFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ConvertXMLToString {
	public String ReadXMLTemplate(String FileName) throws IOException {
		File xmlFile = new File(FileName);
			Reader fileReader = null;
				fileReader = new FileReader(xmlFile);
	  	
		  BufferedReader bufReader = new BufferedReader(fileReader);
		  	StringBuilder sb = new StringBuilder();  
		  		String line = bufReader.readLine();
		 
		  //reading xml template file
		  while( line != null){ 
			  sb.append(line).append("\n"); 
			  line = bufReader.readLine();
		  }
		  	String BizRuleXMLFileContent = sb.toString(); 
		  		return BizRuleXMLFileContent;
	}
}
