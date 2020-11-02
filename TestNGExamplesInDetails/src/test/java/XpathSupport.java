
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 
public class XpathSupport {
	
	/** XML document */
	private Document xml;
	
	/** XPath intance */
	private XPath xpath;

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


	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		System.out.println("Component1TC3");
		
		String filePath = "D:\\zelenium\\vichfiles\\MandatoryFields\\MainFile.xml";
		 
        String fileXML=( readAllBytesJava7( filePath ));
	
		XpathSupport xpath = new XpathSupport(fileXML);
	//	String msgackPath = "/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/author/assignedEntity/representedOrganization";
	//	String msgackPath = "/MCCI_IN200100UV01/creationTime/@value";
		String msgackPath = "/MCCI_IN200100UV01/PORR_IN049006UV/controlActProcess/subject/investigationEvent/subjectOf1/controlActEvent/primaryInformationRecipient/assignedEntity[code/@code=\"T95009\"]/representedOrganization/name";
		String k=xpath.string(String.format("%s", msgackPath));
		System.out.println(k.replaceAll("\\s+", " "));
	}
	//Read file content into string with - Files.readAllBytes(Path path)
	 
    private static String readAllBytesJava7(String filePath) 
    {
        String content = "";
 
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return content;
    }
	
	
}