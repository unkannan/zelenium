package RulesImplementation;

public class RulesToBeImplemented {

public String RulesImplmentationtoFile(String xml2String,String TargetTag,String tagValue) {
	//int taglength=TargetTag.length();
	String SourceTag=null;
		int k=xml2String.indexOf("<"+TargetTag+">");
			int l=xml2String.indexOf("</"+TargetTag+">");
	
			String s="</"+TargetTag+">";
				int check=s.length();
			/*	 if(TargetTag.equalsIgnoreCase("species")) {
					 if(tagValue.contains("MISSING"))
						 return xml2String;
					 SourceTag="<speciescode>AVECH</speciescode>";
					 TargetTag="<speciescode>AVECH</speciescode>\n<"+TargetTag+"/>";
					 xml2String=xml2String.replaceAll(SourceTag.trim(),TargetTag.trim());
					 return xml2String;
				 }*/
					//special cases
					//if(SourceTag.contains("<safetyreport>")
						 SourceTag=xml2String.substring(k,l+check);
							if(tagValue.contains("MISSING") || tagValue.contains("TagNotAvailable"))
								TargetTag="";
							else if(tagValue.length()>0)
								TargetTag="<"+TargetTag+">"+tagValue+"</"+TargetTag+">";
							else
								//TargetTag="</"+TargetTag+">";
								TargetTag="<"+TargetTag+"/>";
	
	System.out.println(SourceTag);
	System.out.println(TargetTag);
	   xml2String=xml2String.replaceAll(SourceTag.trim(),TargetTag.trim());
	   	return xml2String;
}
 
}
