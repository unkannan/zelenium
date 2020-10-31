package vich_file_creation.vich_file_creation;

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
	}
}
