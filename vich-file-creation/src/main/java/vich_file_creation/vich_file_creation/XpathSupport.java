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
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

public class XpathSupport {

	/** XML document */
	private Document xml;

	/** XPath intance */
	private XPath xpath;

	public XpathSupport() {
	}
	static DocumentBuilderFactory f = null;
	static DocumentBuilder b = null;
	static Document doc = null;
	static XPath xPath = null;
	
	static JSONParser parser=null;
	static JSONObject parentObject = null;

	
	public void CreateFileFromVICHTemplate(String templatefileXML, String NullFlavorsTemplate, String jasonxpath,
			String newfilename) throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException, TransformerException, ParseException {

		f = DocumentBuilderFactory.newInstance();
		b = f.newDocumentBuilder();
		doc = b.parse(templatefileXML);
		xPath = XPathFactory.newInstance().newXPath();

		parser = new JSONParser();
		parentObject = (JSONObject) parser.parse(jasonxpath);
		JSONArray parentArray = (JSONArray) parentObject.get("xpath");

		int i = 0;
		while (i < parentArray.size()) {
			JSONObject finalObject = (JSONObject) parentArray.get(i++);
			String xmlxpathstr = finalObject.get("field").toString();
			Node startDateNode = (Node) xPath.compile(xmlxpathstr).evaluate(doc, XPathConstants.NODE);

			if (finalObject.get("value").equals("remove")) {
				RemoNode(startDateNode);
			} else if (finalObject.get("value").equals("null")) {
				AppendNullFlavorNode(startDateNode, xmlxpathstr, NullFlavorsTemplate);
			} else {
				SetXMLText(startDateNode, finalObject.get("value").toString());
			}
		}
		CreatexmlFile(newfilename);
	}
 
 	void SetXMLText(Node startDateNode,String value) throws XPathExpressionException{
				System.out.println(startDateNode.getNodeName());
					startDateNode.setTextContent(value);
	}

	void RemoNode(Node startDateNode) throws XPathExpressionException {
				System.out.println(startDateNode.getNodeName());
					startDateNode.getParentNode().removeChild(startDateNode);
	}
	
	void AppendNullFlavorNode(Node startDateNode,String xmlxpathstr, String NullFlavorsTemplate)
			throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		System.out.println(startDateNode.getNodeName());
			DocumentBuilderFactory f1 = DocumentBuilderFactory.newInstance();
				DocumentBuilder b1 = f.newDocumentBuilder();
					Document doc1 = b1.parse(NullFlavorsTemplate);

		String MainNodeXpath = xmlxpathstr.substring(0,
				(xmlxpathstr.length() - startDateNode.getNodeName().length() - 1));
			Node MainNode = (Node) xPath.compile(MainNodeXpath).evaluate(doc, XPathConstants.NODE);

		Node NullNode = (Node) xPath.compile("/MCCI_IN200100UV01/" + startDateNode.getNodeName()).evaluate(doc1, XPathConstants.NODE);
			NullNode = doc.importNode(NullNode, true);
	    		MainNode.replaceChild(NullNode,startDateNode);
		}

	 

	void CreatexmlFile(String newfilename) throws TransformerException {
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(newfilename));
		transformer.transform(source, result);

		System.out.println("File created " + newfilename);
		System.out.println("********************************************************");
	}
}