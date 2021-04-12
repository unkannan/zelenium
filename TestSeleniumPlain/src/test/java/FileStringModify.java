import java.io.File;
import java.io.IOException;

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
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
public class FileStringModify {
	
	static String fileasString="src/resources/VICH_TestFile.xml";//"d://VICH_TestFile.xml";
	
	@Test
	public void test1() {
	String xmlXpath="/MCCI_IN200100UV01/id/@extension";
	//String fileasString="src/resoruces/VICH_TestFile.xml";
		ReplaceXMLContentForNode(fileasString,xmlXpath);
	}
	
	void ReplaceXMLContentForNode(String file,String xmlXpath){
			try {
				xmlXpathContentchange(file,xmlXpath,"changed  change");
				} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void xmlXpathContentchange(String file,String xmlXpath,String value){
	DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
	DocumentBuilder b = null;
	try {
		b = f.newDocumentBuilder();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Document doc=null;
	try {
		doc = b.parse(file);
	} catch (Exception e) {
		e.printStackTrace();
	} 
		//Batch identifier
		doc=UpdateElementValueInXMLContent(doc,xmlXpath,value);
		writeFinalContentInXMLFile(doc,file);
	}
	 
	private Document UpdateElementValueInXMLContent(Document doc,String xpath,String value){
		XPath xPath = XPathFactory.newInstance().newXPath();
		Node startDateNode = null;
		try {
			startDateNode = (Node) xPath.compile(xpath).evaluate(doc, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		startDateNode.setTextContent(value);
		return doc;
	}

	private void writeFinalContentInXMLFile(Document doc,String newfilename){
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
}
