package eu.europa.ema.phv.adr.vet.vich.tests;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Vich_RegressionTestSuite {
	String templatefileXML="src/test/resources/emaadr/vich/templates/VICH_File_With_All_Elements.xml";
	String DirectoryToCreateFiles = "src/test/resources/emaadr/vich/templates";
	final String NullFlavorsTemplate = "src/test/resources/emaadr/vich/templates/NullFlavorsTemplate.xml";
	File destDir = new File(DirectoryToCreateFiles);
	CreateFile creatingfiles=new CreateFile();
	String xsiNullType=null;
	
	//@Test
	public void A4_TestingMandatoryfieldcheck() throws ParserConfigurationException, SAXException, IOException {
		String JsonXpathObject="{\"xpath\":[{ \"field\":\"/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/primaryInformationRecipient/assignedEntity[code/@code=\\\"T95009\\\"]/representedOrganization/name\",\"value\":\"null\"}]}";
	//	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,JsonXpathObject,destDir + "/" + "newfilename123" + ".xml",NullFlavorsTemplate,xsiNullType);
	}

	@Test
	public void Rule98_B11_NumberOfAnimalsTreatedMustBeInteger() {
	String xpath=null;
	String valuetoprovide=null;
	String KeepReadyWIthValue="<quantity xsi:type=\"PQ\" value=\"7\"/>";
	String ActualXpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/player2/quantity";
	String valuexmlpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/player2/quantity/@value";
			
	//Rule98	B.1.1	Number of Animals Treated 	Error	Number of Animals Treated - B.1.1 is not null	Field Number of Animals Treated - B.1.1 must be Integer & >0	The field Number of Animals Treated - B.1.1 must be a valid positive Integer
	//Scenario 1: Null Check
	xpath="{\"xpath\":[{\"field\":\"/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/player2/quantity\",\"value\":\"null\"}]}\r\n" + "";
	//creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T111_B11_AnimalsTreated_null_optional_p" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	
	//Scenario: valid integer
	valuetoprovide="1";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T981_B11_NoOfAnimalsTreatedValidInteger_validInteger_1_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	
	//Scenario: valid integer
	valuetoprovide="100";
		xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
		System.out.println(xpath);
		creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T982_B11_NoOfAnimalsTreatedValidInteger_validInteger_2_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	
	//Scenario: Invalid integer-negative value
	valuetoprovide="-1";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T983_B11_NoOfAnimalsTreatedValidInteger_NegativeValue_Minus1_Reject" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);

	//Scenario: Invalid integer - value zero
	valuetoprovide="0";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T984_B11_NoOfAnimalsTreatedValidInteger_ZeroValue_Reject" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);	
	}
	
	@Test
	public void Rule99_B11_NumberOfAnimalsTreatedLessthan12digits() {
	String xpath=null;
	String valuetoprovide=null;
	String KeepReadyWIthValue="<quantity xsi:type=\"PQ\" value=\"7\"/>";
	String ActualXpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/player2/quantity";
	String valuexmlpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/player2/quantity/@value";
			
	//99	B.1.1	Number of Animals Treated 	Error	Number of Animals Treated - B.1.1 is not null	length< 12 digits 	The field Number of Animals Treated - B.1.1  exceeds the maximum allowed length(length< 12 digits )
	//Scenario: 12 integer length - Accept
	valuetoprovide="123456789122";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T991_B11_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	
	//Scenario:13 integer length - Reject
		valuetoprovide="1234567891223";
		xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
		System.out.println(xpath);
		creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T992_B11_NoOfAnimalsTreatedLessthan12digits_13digits_Reject" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	}

/*
103	B.1.2	Number of Animals Affected 	Warning	Number of Animals Affected - B.1.2 is not null and (Outcome to Date - B.3.8.1: ongoing!=null or Outcome to Date -B.3.8.2: recovered (normal)!=null or Outcome to Date-B.3.8.3: recovered with sequelae!=null or Outcome to Date-B.3.8.4:died!=null or Outcome to Date-B.3.8.5:euthanized!=null or Outcome to Date-B.3.8.6:Unknnown!=null )	Number of Animals Affected - B.1.2 is the sum of  (Outcome to Date - B.3.8.1: ongoing + Outcome to Date -B.3.8.2: recovered (normal) + Outcome to Date-B.3.8.3: recovered with sequelae + Outcome to Date-B.3.8.4:died + Outcome to Date-B.3.8.5:euthanized  + Outcome to Date-B.3.8.6:Unknnown )	The field Animals Affected - B.1.2  value should be equal to the sum of the Outcome to data fiels under B.3.8 section
104	B.1.2	Number of Animals Affected 	Warning	Number of Animals Affected - B.1.2 is not null Number of Animals Treated - B.1.1 is not null	Number of Animals Affected - B.1.2 >= Number of Animals Treated - B.1.1 	The field Animals Affected - B.1.2  value should be greater than Number of Animals Treated - B.1.1 value
*/

	@Test
	public void Rule100_B12_NumberOfAnimalsAffected_mandatory_nullCheck() {
		//This is mandatory
	String xpath=null;
	String valuetoprovide=null;
	String KeepReadyWIthValue="<quantity xsi:type=\"PQ\" value=\"7\"/>";
	String ActualXpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95005\\\"]/value";
	String valuexmlpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95005\\\"]/value/@value";
			
	//100	B.1.2	Number of Animals Affected 	Error		Number of Animals Affected - B.1.2 must not be null	The field Number of Animals Affected - B.1.2 must be provided
	//Scenario: Mandatory Check as this is mandatory element -  cannot accept NULL
	valuetoprovide="null";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	//creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T991_B11_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	}
	@Test
	public void Rule101_B12_NumberOfAnimalsAffected_MustPositiveInteger() {
		//This is mandatory
	String xpath=null;
	String valuetoprovide=null;
	String KeepReadyWIthValue="<quantity xsi:type=\"PQ\" value=\"7\"/>";
	String ActualXpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95005\\\"]/value";
	String valuexmlpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95005\\\"]/value/@value";
			
	//101	B.1.2	Number of Animals Affected 	Error	Number of Animals Affected - B.1.2 is not null	Number of Animals Affected - B.1.2 must be Integer & >0	The field Animals Affected - B.1.2 must be a valid positive Integer
	//Scenario: Mandatory Check as this is mandatory element -  cannot accept NULL
	valuetoprovide="1";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1011_B11_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	}
	valuetoprovide="100";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1012_B11_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	}
	valuetoprovide="0";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1013_B11_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
	valuetoprovide="-1";
	xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
	System.out.println(xpath);
	creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1014_B11_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}
@Test
public void Rule102_B12_NumberOfAnimalsAffected_Lenglessthan12digits() {
	//This is mandatory
String xpath=null;
String valuetoprovide=null;
String KeepReadyWIthValue="<quantity xsi:type=\"PQ\" value=\"7\"/>";
String ActualXpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95005\\\"]/value";
String valuexmlpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95005\\\"]/value/@value";
		
//102	B.1.2	Number of Animals Affected 	Error	Number of Animals Affected - B.1.2 is not null	length< 12 digits 	The field Animals Affected - B.1.2  exceeds the maximum allowed length.
valuetoprovide="12345678911";
xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
System.out.println(xpath);
creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1021_B12_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}
valuetoprovide="123456789112";
xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
System.out.println(xpath);
creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1022_B12_NoOfAnimalsTreatedLessthan12digits_12digits_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}
valuetoprovide="1234567891123";
xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
System.out.println(xpath);
creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1023_B12_NoOfAnimalsTreatedLessthan12digits_12digits_Reject" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}	

@Test
public void Rule105_B121_AttendingVeterinarian(){
String xpath=null;
String valuetoprovide=null;
String KeepReadyWIthValue="<value code=\"C82488\" codeSystem=\"2.16.840.1.113883.13.197\" displayName=\"EXCELLENT\" xsi:type=\"CE\"/>";
String ActualXpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95006\\\"]/value";
String valuexmlpath="/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/component/adverseEventAssessment/subject1/primaryRole/subjectOf2/observation[code/@code=\\\"T95006\\\"]/value/@code";
		
//105	B.1.2.1	Attending Veterinarian's Assessment of Health Status Prior to VMP & Code	Error	Attending Veterinarian's Assessment of Health Status Prior to VMP & Code -B.1.2.1 is not null	Attending Veterinarian's Assessment of Health Status Prior to VMP & Code -B.1.2.1 has value which matches "GL30 e. Vet Health Status Assessment"  or a valid null flavor
//optional
valuetoprovide="C82488";
xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
System.out.println(xpath);
creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1051_B121_AttendingVeterinarian_lookupCheck_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}
valuetoprovide="C64975";
xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
System.out.println(xpath);
creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1052_B121_AttendingVeterinarian_lookupCheck_Accept" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}
valuetoprovide="unknown";
xpath="{\"xpath\":[{\"field\":\""+valuexmlpath+"\",\"value\":\""+valuetoprovide+"\"}]}";
System.out.println(xpath);
creatingfiles.CreateVICHFilesFromInputSheet(templatefileXML,ActualXpath,xpath,destDir + "/" + "T1053_B121_AttendingVeterinarian_lookupCheck_Reject" + ".xml",NullFlavorsTemplate,xsiNullType,KeepReadyWIthValue);
}	
}
