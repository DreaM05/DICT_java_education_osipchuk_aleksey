package Hangman;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class hangman {

    public static void main (String[] args) {

        //Этап №1
        System.out.print("HANGMAN \n" + "The game will be available soon\n");

        //Этап №2
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the word: ");
        String variant = scanner.nextLine();
        if (wordsGenerator().equals(variant)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }

    //Этап №3
    public static String wordsGenerator() {
        List<String> words = new ArrayList<>();
        words.add("python");
        words.add("java");
        words.add("javascript");
        words.add("kotlin");
        int randomIndex = ThreadLocalRandom.current().nextInt(words.size());
        String word = words.get(randomIndex);
        return word;
    }
}