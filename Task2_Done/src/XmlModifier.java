import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlModifier
{
    public static Document AddSomething(Document doc)
    {
        Element element = doc.createElement("book");
        element.setAttribute("id", "bk5083");

        Element author = doc.createElement("author");
        author.appendChild(doc.createTextNode("Martin, Bob"));
        element.appendChild(author);

        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode("Clean code"));
        element.appendChild(title);

        Element genre = doc.createElement("genre");
        genre.appendChild(doc.createTextNode("Programming"));
        element.appendChild(genre);

        Element price = doc.createElement("price");
        price.appendChild(doc.createTextNode("19.95"));
        element.appendChild(price);

        Element publish_date = doc.createElement("publish_date");
        publish_date.appendChild(doc.createTextNode("2008-07-17"));
        element.appendChild(publish_date);

        Element description = doc.createElement("description");
        description.appendChild(doc.createTextNode("Even bad code can function. " +
                "\nBut if code isn’t clean, it can bring a development organization to its knees. " +
                "\nEvery year, countless hours and significant resources are lost because of poorly written code. \n" +
                "But it doesn’t have to be that way.\n"));
        element.appendChild(description);

        doc.getDocumentElement().appendChild(element);

        return doc;
    }

    public static Document EditSomething(Document doc)
    {
        NodeList bunchOfNodes = doc.getElementsByTagName("book");

        for (int i = 0; i < bunchOfNodes.getLength(); i++) {

            Node node = bunchOfNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                if(eElement.getAttribute("id").equals("bk102"))
                {
                    eElement.getElementsByTagName("author").item(0).setTextContent("Kim is no longer the author!");
                    eElement.getElementsByTagName("genre").item(0).setTextContent("Changed genre!");
                    eElement.getElementsByTagName("price").item(0).setTextContent("999.99!");
                    eElement.getElementsByTagName("publish_date").item(0).setTextContent("2023-12-20");
                    eElement.getElementsByTagName("description").item(0).setTextContent("I remove the original description, now it does not contain any.!");
                }
            }
        }

        return doc;
    }

    public static Document RemoveSomething(Document doc)
    {
        NodeList bunchOfNodes = doc.getElementsByTagName("book");

        for (int i = 0; i < bunchOfNodes.getLength(); i++) {

            Node node = bunchOfNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) node;
                if(eElement.getAttribute("id").equals("bk101") ||
                        eElement.getAttribute("id").equals("bk103") ||
                        eElement.getAttribute("id").equals("bk105"))
                {
                    eElement.getParentNode().removeChild(eElement);
               }
            }
        }
        return doc;
    }
}
