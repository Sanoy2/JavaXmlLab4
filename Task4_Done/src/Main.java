import org.w3c.dom.Document;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program started");

        Xml2Txt();

        System.out.println("Program finished");
        System.out.println("Created by: Krzysztof Tomków");
    }

    public static void Xml2Txt()
    {
        String textPath = "employees.txt";
        String xmlPath = "employees.xml";

        Document doc = XmlLoader.ReadDocument(xmlPath);
        XmlToTxt.SaveXmlToTxt(textPath, doc);

    }
}
