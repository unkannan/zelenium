package vich_file_creation.vich_file_creation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class XpathSupport {
	 
	public void createfilefromtemplate1(String templatefileXML, String jasonxpath, String newfilename){

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = null;
		try {
			b = f.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = b.parse(templatefileXML);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONParser parser = new JSONParser();

		JSONObject parentObject = null;
		try {
			parentObject = (JSONObject) parser.parse(jasonxpath);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONArray parentArray = (JSONArray) parentObject.get("xpath");
		int i = 0;
		System.out.println(parentArray.size());
		while (i < parentArray.size()) {
				JSONObject finalObject = (JSONObject) parentArray.get(i++);
					System.out.println(finalObject.get("field"));
				String xpath = finalObject.get("field").toString();
					System.out.println(finalObject.get("value"));

			UpdateElementValueInXMLContent(doc,xpath,finalObject.get("value").toString());
			UpdateBatchMessageIdentifiers(doc,newfilename);
		}
		// write the content into xml file
		newfilename=writeFinalContentInXMLFile(doc,newfilename);
		
		System.out.println("File created " + newfilename);
		System.out.println("********************************************************");
	}
	
	private void UpdateElementValueInXMLContent(Document doc,String xpath,String value){
		XPath xPath = XPathFactory.newInstance().newXPath();
		Node startDateNode = null;
		try {
			startDateNode = (Node) xPath.compile(xpath).evaluate(doc, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		startDateNode.setTextContent(value);
	}
	
	private void UpdateBatchMessageIdentifiers(Document doc,String newfilename) {
		File f=new File(newfilename);
		//Updating Batch ID
		UpdateElementValueInXMLContent(doc,"/MCCI_IN200100UV01/id/@extension",f.getName().substring(0,f.getName().length()-4));
		
		//Updating Message id
		UpdateElementValueInXMLContent(doc,"/MCCI_IN200100UV01/PORR_IN049006UV/id/@extension",f.getName().substring(0,f.getName().length()-4));
		
		//updating case id with random number in last chars
		int n = 10000 + new Random().nextInt(90000); //generating random no.
		UpdateElementValueInXMLContent(doc,"/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/id/@extension",
				"USA-GAPINDSY-"+n);

	}
	
	private String writeFinalContentInXMLFile(Document doc,String newfilename){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(newfilename));
		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return newfilename;
		
	}
}