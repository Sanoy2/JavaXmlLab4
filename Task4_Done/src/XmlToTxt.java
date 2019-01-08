import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlToTxt
{
    public static void SaveXmlToTxt(String path, Document doc)
    {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : DocToLines(doc))
            {
                bufferedWriter.write(line + "\n");
            }

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Document saved to txt file");

        } catch (Exception e)
        {

        }
    }

    private static List<String> DocToLines(Document doc)
    {
        List<String> lines = new ArrayList<String>();

        NodeList bunchOfNodes = doc.getElementsByTagName("employee");

        String line = "name,dateOfBirth,dept,jobTitle";
        lines.add(line);

        for (int i = 0; i < bunchOfNodes.getLength(); i++)
        {
            Node node = bunchOfNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {

                Element element = (Element) node;

                line = element.getElementsByTagName("name").item(0).getTextContent() + ",";
                line += element.getElementsByTagName("dateOfBirth").item(0).getTextContent() + ",";
                line += element.getElementsByTagName("dept").item(0).getTextContent() + ",";
                line += element.getElementsByTagName("jobTitle").item(0).getTextContent();
            }

            lines.add(line);
        }

        return lines;
    }
}
