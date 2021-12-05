package Hangman;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class hangman {

    public static void main (String[] args) {

        System.out.print("HANGMAN \n" + "The game will be available soon\n");
        Scanner scanner = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        words.add("python");
        words.add("java");
        words.add("javascript");
        words.add("kotlin");
        int randomIndex = ThreadLocalRandom.current().nextInt(words.size());

        for (int i = 0; i < words.get(randomIndex).length(); i++){
            if (i<2){
                System.out.print(words.get(randomIndex).charAt(i));
            }
            else {
                System.out.print("-");
            }
        }

        System.out.print("\nGuess the word: ");
        String variant = scanner.nextLine();

        if (words.get(randomIndex).equals(variant)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}