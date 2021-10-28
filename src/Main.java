import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String continuePlaying = "n";
        String[] wordsFromFile = WordReader.wordReader();
        do {
            String wordToGuess = wordsFromFile[random.nextInt(wordsFromFile.length)];
            String guessedLetters = "";
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            int lives = 6;
            boolean win = false;

            while (lives > 0 && win == false) {
                System.out.println("");
                win = true;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    char charToWrite = wordToGuess.charAt(i);
                    if (guessedLetters.contains(String.valueOf(charToWrite))) {
                        System.out.print(charToWrite);
                    } else {
                        System.out.print("_");
                        win = false;
                    }
                }
                if (win == false) {
                    System.out.println("");
                    System.out.println("you have " + lives + " lives");
                    System.out.println("you have guessed " + guessedLetters);
                    System.out.println("guess a letter");
                    String guessedLetter = scanner.nextLine();
                    if (guessedLetter.length() == 1 && alphabet.contains(guessedLetter)) {
                        if (!guessedLetters.contains(guessedLetter)) {
                            guessedLetters = guessedLetters.concat(guessedLetter);
                            if (wordToGuess.contains(guessedLetter)) {
                                System.out.println("letter is in the word, good guess!");
                            } else {
                                System.out.println("letter is not in word, bad guess");
                                lives -= 1;
                            }
                        } else {
                            System.out.println("letter already guessed");
                        }
                    } else {
                        System.out.println("invalid guess");
                    }
                }
            }
            if (win == true) {
                System.out.println("");
                System.out.println("you win!");
            } else if (lives == 0) {
                System.out.println("");
                System.out.println("you lose");
            }
            System.out.println("do you want to play again? (y/n)");
            continuePlaying = scanner.nextLine();
        } while (continuePlaying.equals("y"));
    }
}
