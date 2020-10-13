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

	/** XML document */
	private Document xml;

	/** XPath intance */
	private XPath xpath;

	public XpathSupport() {
	}

	public XpathSupport(String xmlAsString) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		this.xml = builder.parse(new InputSource(new StringReader(xmlAsString)));

		this.xpath = XPathFactory.newInstance().newXPath();
	}

	public String string(String xpathExpression) throws XPathExpressionException {
		return (String) evaluate(xpathExpression, XPathConstants.STRING);
	}

	public Double number(String xpathExpression) throws XPathExpressionException {
		return (Double) evaluate(xpathExpression, XPathConstants.NUMBER);
	}

	private Object evaluate(String xpathExpression, QName returnType) throws XPathExpressionException {
		return xpath.compile(xpathExpression).evaluate(xml, returnType);
	}

	/*
	 * public static void main(String args[]) throws ParserConfigurationException,
	 * SAXException, IOException, XPathExpressionException {
	 * System.out.println("Component1TC3");
	 * 
	 * String filePath = "D:\\zelenium\\vichfiles\\MandatoryFields\\MainFile.xml";
	 * 
	 * String fileXML=( readAllBytesJava7( filePath ));
	 * 
	 * XpathSupport xpath = new XpathSupport(fileXML); // String msgackPath =
	 * "/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/author/assignedEntity/representedOrganization";
	 * // String msgackPath = "/MCCI_IN200100UV01/creationTime/@value"; String
	 * msgackPath =
	 * "/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/primaryInformationRecipient/assignedEntity[code/@code=\"T95009\"]/addr/country";
	 * String k=xpath.string(String.format("%s", msgackPath));
	 * System.out.println(k.replaceAll("\\s+", " ")); }
	 */

	private static String readAllBytesJava7(String filePath) {
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public void createfilefromtemplate(String templatefileXML, String xpath, String value, String newfilename)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException,
			TransformerException {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(templatefileXML);
		XPath xPath = XPathFactory.newInstance().newXPath();
		System.out.println(xpath);

		ModifyXMLdataUsingJasonFile(templatefileXML, xpath);
		Node startDateNode = (Node) xPath.compile(xpath).evaluate(doc, XPathConstants.NODE);
		System.out.println(startDateNode.getTextContent());
		startDateNode.setTextContent(value);

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(newfilename));
		transformer.transform(source, result);

		System.out.println("Done");
	}

	public void ModifyXMLdataUsingJasonFile(String templatefileXML, String jasonxpath) {
		JSONParser parser = new JSONParser();

		JSONObject parentObject = null;
		try {
			parentObject = (JSONObject) parser.parse(jasonxpath);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
		}
	}

	@SuppressWarnings("unchecked")
	public void getJason(String jsonstr) throws ParseException {
		String jsonstr5 = "{\r\n" + "\"xpath\":[\r\n" + "{ \"field\":\"Avengers\",\r\n" + "\"value\":\"2012\"\r\n"
				+ "},\r\n" + "{\"field\":\"Avengers2\",\r\n" + "\"value\":\"2014\"\r\n" + "}\r\n" + "]\r\n" + "}";

		// String
		// jsonstr6="{\"xpath\":[{\"field\":\"Avengers\",\"value\":\"2012\"},{\"field\":\"Avengers2\",\"value\":\"2014\"}]}";
		String jsonstr6 = "{\"xpath\":[{ \"field\":\"/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/primaryInformationRecipient/assignedEntity[code/@code=\\\"T95009\\\"]/addr/country\",\"value\":\"countryNew\"},{\"field\":\"/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/primaryInformationRecipient/assignedEntity[code/@code=\\\"T95009\\\"]/addr/city\",\"value\":\"city2014\"}]}";
		// jsonstr6=jsonstr6.replace("\"", "\\\"");
		JSONParser parser = new JSONParser();
		System.out.println(jsonstr5.trim());
		System.out.println(jsonstr6.trim());
		JSONObject parentObject = (JSONObject) parser.parse(jsonstr6.trim());
		JSONArray parentArray = (JSONArray) parentObject.get("xpath");

		int i = 0;
		System.out.println(parentArray.size());
		while (i < parentArray.size()) {
			JSONObject finalObject = (JSONObject) parentArray.get(i++);
			System.out.println(finalObject.get("field"));
			System.out.println(finalObject.get("value"));
		}

	}

	public void createfilefromtemplate1(String templatefileXML, String jasonxpath, String newfilename)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException,
			TransformerException, ParseException {

		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(templatefileXML);
		XPath xPath = XPathFactory.newInstance().newXPath();

		JSONParser parser = new JSONParser();

		JSONObject parentObject = null;
		parentObject = (JSONObject) parser.parse(jasonxpath);
		JSONArray parentArray = (JSONArray) parentObject.get("xpath");
		int i = 0;
		System.out.println(parentArray.size());
		while (i < parentArray.size()) {
			JSONObject finalObject = (JSONObject) parentArray.get(i++);
			System.out.println(finalObject.get("field"));
			String xpath = finalObject.get("field").toString();
			System.out.println(finalObject.get("value"));

			Node startDateNode = (Node) xPath.compile(xpath).evaluate(doc, XPathConstants.NODE);
			startDateNode.setTextContent(finalObject.get("value").toString());
		}
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(newfilename));
		transformer.transform(source, result);

		System.out.println("File created "+newfilename);
		System.out.println("********************************************************");
		System.out.println();
	}
}