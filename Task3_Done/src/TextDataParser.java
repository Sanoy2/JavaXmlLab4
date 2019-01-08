import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextDataParser
{
    public static Document ParseFileToDocument(String path)
    {
        try
        {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();

            Element root = doc.createElement("employees");
            doc.appendChild(root);

            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;

            line = in.readLine();

            List<String> Elements = ReadElementsNames(line);

            while((line = in.readLine()) != null)
            {
                AddElement(line, Elements, doc);
            }

            in.close();
            return doc;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    private static List<String> ReadElementsNames(String line)
    {
        List<String> Elements = new ArrayList<String>();
        for (String part : line.split(",")) {
            Elements.add(part);
        }
        return Elements;
    }

    private static void AddElement(String line, List<String> Elements, Document doc)
    {
        Element element = doc.createElement("employee");

        String[] Data = line.split(",");

        for(int i = 0; i < Data.length; i++)
        {
            Element dataPart = doc.createElement(Elements.get(i));
            dataPart.appendChild(doc.createTextNode(Data[i]));
            element.appendChild(dataPart);
        }

        Element root = doc.getDocumentElement();
        root.appendChild(element);
    }
}
