import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
    private HashSet<String> dictionary = new HashSet<>();

    /**
     * Metoda na pridani spravnych sklonovanych slov ze souboru do HashSetu
     * @param filename- nazev souboru, ktera obsahuje spravne slovy
     * @throws IOException
     */
    public void add(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String lines;
        while((lines = br.readLine()) !=null){
            dictionary.add(lines.toLowerCase());
        }
        br.close();
    }

    /**
     * Metoda na rozkladani vety na samostatne slovy, pak porovnava se slovy, ktere jsou ve prechodzim HashSetu
     * @return spatne skolovanych slov
     */
    public String checkInput(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> misspelledWords=new ArrayList<>();
        System.out.println("Enter a word or sentence to check spelling: ");
        String inputWord = scanner.nextLine();
        Scanner wordScanner = new Scanner(inputWord);
        while (wordScanner.hasNext()){
            String word = wordScanner.next();
            if (!dictionary.contains(word.toLowerCase())) {
                misspelledWords.add(word);
            }
        }
        if (misspelledWords.size()==1){
            return misspelledWords.get(0)+"is misspelled";
        } else if (misspelledWords.size()>1) {
            return String.join(", ", misspelledWords)+" are misspelled";
        }
        return "Your word/sentence is correctly spelled.";

    }

    public HashSet<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashSet<String> dictionary) {
        this.dictionary = dictionary;
    }
}
