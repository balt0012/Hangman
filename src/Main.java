import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //setup before the game runs
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String continuePlaying;
        String[] wordsFromFile = WordReader.wordReader();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //setup for the start of each round
        do {
            String wordToGuess = wordsFromFile[random.nextInt(wordsFromFile.length)];
            String guessedLetters = "";
            int lives = 6;
            boolean win = false;

            //printing the word that is being guessed and checking if the player has won
            while (lives > 0 && !win) {
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
                //printing the info for a turn
                if (!win) {
                    System.out.println("");
                    System.out.println("you have " + lives + " lives");
                    System.out.println("you have guessed " + guessedLetters);
                    System.out.println("guess a letter");

                    //player guesses a letter and it is added to the guessed letters array
                    String guessedLetter = scanner.nextLine();
                    if (guessedLetter.length() == 1 && alphabet.contains(guessedLetter)) {
                        if (!guessedLetters.contains(guessedLetter)) {
                            guessedLetters = guessedLetters.concat(guessedLetter);

                            //checking if the guess was correct or not
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

            //prints the messages for winning and losing
            if (win) {
                System.out.println("");
                System.out.println("you win!");
            } else if (lives == 0) {
                System.out.println("");
                System.out.println("you lose");
            }

            //asks the player if they want to play another round
            do {
                System.out.println("do you want to play again? (y/n)");
                continuePlaying = scanner.nextLine();
            } while (!Objects.equals(continuePlaying, "y") && !Objects.equals(continuePlaying, "n"));
        } while (continuePlaying.equals("y"));
    }
}