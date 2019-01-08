import org.w3c.dom.Document;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program started");

        String path = "Book.xml";
        Document doc = XmlLoader.ReadDocument(path);

        XmlDisplayer.Display(doc);

        doc = XmlModifier.AddSomething(doc);
        doc = XmlModifier.EditSomething(doc);
        doc = XmlModifier.RemoveSomething(doc);

        System.out.println("After XML object modification:");

        XmlDisplayer.Display(doc);

        XmlSaver.SaveXml("NewBook.xml", doc);

        System.out.println("Program finished");
    }
}
