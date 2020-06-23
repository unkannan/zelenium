package vich_file_creation.vich_file_creation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class createfiles {
	static String ExcelFilePath = "C:\\Users\\kannanu\\OneDrive\\VICH\\MandatoryRuleFile.xlsx";
	static String validtemplatefile = "Files/Templates/VICH_TestFile.xml";
	static String VICH_TestFile_AllFields = "Files/Templates/VICH_TestFile_AllFields";
	static String NullFlavorsTemplate = "Files/Templates/NullFlavorsTemplate.xml";

	@Test
	public void generatelenchecktestdatafiles() throws IOException {
		// ExcelReadin
		InputStream inp = new FileInputStream(ExcelFilePath);
		Workbook wb = new XSSFWorkbook(inp);
		int LengthChecks = 2;
		Sheet sheet = wb.getSheetAt(LengthChecks);
		XpathSupport createFile = new XpathSupport();
		final int xmlField = 6;
		final int flagcheck = 0;
		final int filename = 7;

		for (int j = 1; j < 400 - 1; j++) {
			try {
				if (sheet.getRow(j).getCell(flagcheck).toString().equalsIgnoreCase("y")) {
					String jasonString = sheet.getRow(j).getCell(xmlField).getStringCellValue();
					String newfilename = sheet.getRow(j).getCell(filename).getStringCellValue();
					System.out.println(sheet.getRow(j).getCell(1));
					try {
						// createFile.CreateFileFromVICHTemplate(validtemplatefile, NullFlavorsTemplate,
						// jasonString,"Files/"+sheet.getSheetName()+"/" + newfilename + ".xml");
						createFile.CreateFileFromVICHTemplate(VICH_TestFile_AllFields, NullFlavorsTemplate, jasonString,
								"Files/" + sheet.getSheetName() + "/" + newfilename + ".xml");
					} catch (Exception e) {
						System.out.println("Error in creating file > " + newfilename + ".xml");
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
			}
		}
	}

	@Test
	public void generatemandatorychecktestdatafiles() throws IOException {
		// ExcelReadin
		InputStream inp = new FileInputStream(ExcelFilePath);
		Workbook wb = new XSSFWorkbook(inp);
		int MandatoryChecks = 1;
		Sheet sheet = wb.getSheetAt(MandatoryChecks);
		XpathSupport createFile = new XpathSupport();
		final int xmlField = 6;
		final int flagcheck = 0;
		final int filename = 7;

		for (int j = 1; j < 400 - 1; j++) {
			try {
				if (sheet.getRow(j).getCell(flagcheck).toString().equalsIgnoreCase("y")) {
					String jasonString = sheet.getRow(j).getCell(xmlField).getStringCellValue();
					String newfilename = sheet.getRow(j).getCell(filename).getStringCellValue();
					System.out.println(sheet.getRow(j).getCell(1));
					try {
						createFile.CreateFileFromVICHTemplate(validtemplatefile, NullFlavorsTemplate, jasonString,
								"Files/" + sheet.getSheetName() + "/" + newfilename + ".xml");
					} catch (Exception e) {
						System.out.println("Error in creating file > " + newfilename + ".xml");
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
			}
		}
	}
	/*
	 * public static void main(String args[]) throws EncryptedDocumentException,
	 * InvalidFormatException, IOException, XPathExpressionException,
	 * ParserConfigurationException, SAXException, TransformerException,
	 * ParseException {
	 * 
	 * 
	 * // ExcelReadin InputStream inp = new FileInputStream(ExcelFilePath); Workbook
	 * wb = new XSSFWorkbook(inp); Sheet sheet = wb.getSheetAt(2); int
	 * MandatoryChecks=1,LengthChecks=2; XpathSupport createFile = new
	 * XpathSupport(); final int xmlField = 6; final int flagcheck = 0; final int
	 * filename = 7;
	 * 
	 * 
	 * for (int j = 1; j < 400 - 1; j++) { try { if
	 * (sheet.getRow(j).getCell(flagcheck).toString().equalsIgnoreCase("y")) {
	 * //String jasonString = sheet.getRow(j).getCell(xmlField).toString(); String
	 * jasonString = sheet.getRow(j).getCell(xmlField).getStringCellValue(); String
	 * newfilename = sheet.getRow(j).getCell(filename).getStringCellValue();
	 * System.out.println(sheet.getRow(j).getCell(1)); try {
	 * //createFile.CreateFileFromVICHTemplate(validtemplatefile,
	 * NullFlavorsTemplate, jasonString,"Files/"+sheet.getSheetName()+"/" +
	 * newfilename + ".xml");
	 * createFile.CreateFileFromVICHTemplate(VICH_TestFile_AllFields,
	 * NullFlavorsTemplate, jasonString,"Files/"+sheet.getSheetName()+"/" +
	 * newfilename + ".xml"); } catch (Exception e) {
	 * System.out.println("Error in creating file > " + newfilename + ".xml");
	 * e.printStackTrace(); } } } catch (Exception e) { } } }
	 * 
	 */
}
