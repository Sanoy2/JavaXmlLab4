public class Main {

    public static void main(String[] args) {
        System.out.println("Program started");

        XmlSaver.SaveXml("employees.xml",TextDataParser.ParseFileToDocument("employees.txt"));

        System.out.println("Program finished");
    }
}
