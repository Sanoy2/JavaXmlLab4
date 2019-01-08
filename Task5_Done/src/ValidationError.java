import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class ValidationError implements ErrorHandler
{
    public void warning(SAXParseException e)
    {
        System.out.println("Warning: ");
        printInfo(e);
    }

    public void error(SAXParseException e)
    {
        System.out.println("Error: ");
        printInfo(e);
    }

    public void fatalError(SAXParseException e)
    {
        System.out.println("Fatal error: ");
        printInfo(e);
    }

    private void printInfo(SAXParseException e)
    {
        System.out.println("   Public ID: " + e.getPublicId());
        System.out.println("   System ID: " + e.getSystemId());
        System.out.println("   Line number: " + e.getLineNumber());
        System.out.println("   Column number: " + e.getColumnNumber());
        System.out.println("   Message: " + e.getMessage());
    }
}
