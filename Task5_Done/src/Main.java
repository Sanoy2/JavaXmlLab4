public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Program started");

        String CorrectFilePath = "Correct_data.xml";
        String IncorrectFilePath = "Incorrect_data.xml";

        XmlValidator.ValidateAndPrintResult(CorrectFilePath);
        XmlValidator.ValidateAndPrintResult(IncorrectFilePath);

        System.out.println("Program finished");
    }


}
