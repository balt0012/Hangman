import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = "string";
        String guessedLetters = "";
        int lives = 6;

        while (lives > 0){

        }
    }

    public static String guessLetter(String letter, String guessedLetters, String wordToGuess, int lives){
        if(!guessedLetters.contains(letter)){
            guessedLetters.concat(letter);
            if(wordToGuess.contains(letter)){
                System.out.println("letter is in the word, good guess!");
            } else {
                System.out.println("letter is not in word, bad guess");
                lives -= 1;
            }
        } else {
            System.out.println("letter already guessed");
        }
        return guessedLetters;
    }
}
