import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlValidator
{
    public static void ValidateAndPrintResult(String path)
    {
        System.out.println("Validating file: " + path);
        if(Validate(path))
        {
            System.out.println("Data valid");
        }
        System.out.println();
    }

    public static boolean Validate(String path)
    {
        try
        {
            File file = new File(path);
            DocumentBuilderFactory builderFactory
                    = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(true); // Default is false
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            ErrorHandler errorHandler = new ValidationError();
            documentBuilder.setErrorHandler(errorHandler);
            Document doc = documentBuilder.parse(file);
            return true;
        }
        catch (ParserConfigurationException e)
        {
            System.out.println(e.toString());
            return false;
        }
        catch (SAXException e)
        {
            System.out.println(e.toString());
            return false;
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
            return false;
        }
    }
}
