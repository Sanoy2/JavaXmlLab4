import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class ValidationErrorHandler implements ErrorHandler
{
    private boolean valid;
    ValidationErrorHandler()
    {
        Reset();
    }

    public void Reset()
    {
        valid = true;
    }

    public boolean WasValid()
    {
        return valid;
    }

    public void warning(SAXParseException e)
    {
        System.out.println("Warning: ");
        valid = false;
        printInfo(e);
    }

    public void error(SAXParseException e)
    {
        System.out.println("Error: ");
        valid = false;
        printInfo(e);
    }

    public void fatalError(SAXParseException e)
    {
        System.out.println("Fatal error: ");
        valid = false;
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
