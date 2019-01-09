import org.w3c.dom.Document;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program started");

        XmlSaver.SaveXml("employees.xml",TextDataParser.ParseFileToDocument("employees.txt"));

        System.out.println("Program finished");
        System.out.println("Created by: Krzysztof Tomków");
    }

    private static void Text2XML()
    {
        String textPath = "employees.txt";
        String xmlPath = "employees.xml";

        Document document = TextDataParser.ParseFileToDocument(textPath);
        XmlSaver.SaveXml(xmlPath, document);
    }
}
