import java.io.IOException;


public class SpellChecker {


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        try {
            dictionary.add("Dictionary.txt");
            System.out.println(dictionary.checkInput());

        }catch (IOException e) {
            System.out.println("File not found");
        }






    }
}
