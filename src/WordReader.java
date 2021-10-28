import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordReader {
    public static String[] wordReader() {
        String[] wordsFromFile = {};
        try {
            File words = new File("resources/words.csv");
            Scanner sc = new Scanner(words);
            while (sc.hasNextLine()) {
                String word = sc.nextLine();
                String[] newWords = new String[wordsFromFile.length + 1];
                for (int i = 0; i < wordReader().length; i++) {
                    newWords[i] = wordsFromFile[i];
                }
                newWords[wordsFromFile.length] = word;
                wordsFromFile = newWords;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
        return wordsFromFile;
    }
}
