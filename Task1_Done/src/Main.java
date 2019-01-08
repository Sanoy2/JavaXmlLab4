import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Program started");

        String xmlFilePath = "task1.xml";

        try
        {
            System.out.println("Starting creating XML file");

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("ComputerEngineering");
            document.appendChild(root);

            Element course = document.createElement("Course");

            course.setAttribute("Name", "Application programming - Java and XML technologies");
            course.setAttribute("Author", "Krzysztof Tomków");

            root.appendChild(course);

            Element topic1 = document.createElement("Topics");
            topic1.appendChild(document.createTextNode("Sample topic here"));

            Element topic2 = document.createElement("Topics");
            topic2.appendChild(document.createTextNode("Another topic here"));

            course.appendChild(topic1);
            course.appendChild(topic2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

            transformer.transform(domSource, streamResult);

            System.out.println("XML File created");

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Program finished");
    }
}
