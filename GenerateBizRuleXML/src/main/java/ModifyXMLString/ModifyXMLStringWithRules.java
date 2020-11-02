package ModifyXMLString;

import java.io.IOException;

import RulesImplementation.RulesToBeImplemented;

public class ModifyXMLStringWithRules{

	RulesToBeImplemented RulesImplementaion;
	
	public String CreateNewBizRuleFileXMLContent(String bizRuleXMLFileContent,String xmlTagColumn1) throws IOException {
	  	String [] dataRecords=xmlTagColumn1.split("\n");
	  		for(String record:dataRecords) {
	  			System.out.println(record);
	  				bizRuleXMLFileContent=ModifyXMLContentRecordWise(bizRuleXMLFileContent,record);
	  		}
		return bizRuleXMLFileContent.trim();
}

private String ModifyXMLContentRecordWise(String bizRuleXMLFileContent, String record) {
	RulesImplementaion=new RulesToBeImplemented();
	String [] dataRecords=record.split("/");
	String LastRecord=null;
		for(String records:dataRecords) 
				LastRecord=records;
		
	System.out.println(LastRecord);
	  		//int ActualTagindex=record.indexOf("/");
	  		int equalToIndex=LastRecord.indexOf("=");
	  		if(equalToIndex > 0) {
	  		String ActualTagToChange=LastRecord.substring(0,equalToIndex);
	  			String TagValue=LastRecord.substring(equalToIndex+1,LastRecord.length());
	  			bizRuleXMLFileContent=RulesImplementaion.RulesImplmentationtoFile(bizRuleXMLFileContent,ActualTagToChange,TagValue);
	  		}
	  			return bizRuleXMLFileContent;
}
}
