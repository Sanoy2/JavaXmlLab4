import org.w3c.dom.Document;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program started");

        Document doc = XmlLoader.ReadDocument("employees.xml");

        XmlToTxt.SaveXmlToTxt("employees.txt", doc);

        System.out.println("Program finished");

    }
}
