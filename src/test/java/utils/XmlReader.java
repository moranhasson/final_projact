package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlReader {

    public static String getElementValueFromXML(String filePath, String elementName) {
        try {
            // Create a DocumentBuilderFactory object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder object
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the input XML file to get a Document object
            Document document = builder.parse(new File(filePath));
            // Get the element with the specified name from the document
            Element element = (Element) document.getElementsByTagName(elementName).item(0);
            // Get the text content of the element and return it
            return element.getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Element not found
    }
}