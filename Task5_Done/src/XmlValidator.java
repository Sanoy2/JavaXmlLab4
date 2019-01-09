import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlValidator
{
    public static void ValidateAndPrintResult(String path)
    {
        System.out.println("********************");
        System.out.println("Validating file: " + path);

        boolean valid = Validate(path);

        if(valid)
        {
            System.out.println(">>> Data valid <<<");
        }
        else
        {
            System.out.println("!!! Data invalid !!!");
        }
        System.out.println("********************");

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
            ErrorHandler errorHandler = new ValidationErrorHandler();
            ((ValidationErrorHandler) errorHandler).Reset();
            documentBuilder.setErrorHandler(errorHandler);
            Document doc = documentBuilder.parse(file);
            return ((ValidationErrorHandler) errorHandler).WasValid();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
            return false;
        }
    }
}
