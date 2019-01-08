import org.w3c.dom.*;

public class XmlDisplayer
{
    public static void Display(Document doc)
    {
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList bunchOfNodes = doc.getElementsByTagName("book");

        System.out.println("");
        System.out.println("***********************");
        System.out.println("Books in catalog:");
        System.out.println("***********************");

        for (int i = 0; i < bunchOfNodes.getLength(); i++) {

            Node node = bunchOfNodes.item(i);

//            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            System.out.println("\nBook:");

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                System.out.println("Book id : " + element.getAttribute("id"));
                System.out.println("Author : " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Title : " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Genre : " + element.getElementsByTagName("genre").item(0).getTextContent());
                System.out.println("Price : " + element.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Publish date : " + element.getElementsByTagName("publish_date").item(0).getTextContent());
                System.out.println("Description : " + element.getElementsByTagName("description").item(0).getTextContent());
            }
        }
    }
}
