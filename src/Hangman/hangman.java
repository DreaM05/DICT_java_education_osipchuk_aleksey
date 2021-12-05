package Hangman;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class hangman {

    public static void main (String[] args) {

        char letter;
        int letters;
        int num = 1;

        System.out.print("HANGMAN \n" + "The game will be available soon\n");
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        List<String> words = new ArrayList<>();
        words.add("python");
        words.add("java");
        words.add("javascript");
        words.add("kotlin");
        int randomIndex = ThreadLocalRandom.current().nextInt(words.size());
        String hiddenword = words.get(randomIndex);
        letters = hiddenword.length();
        for (int i = 0; i < letters; i++){
            System.out.print("-");
        }
        char[] word = new char[letters];
        char[] attempts = new char[20];
        int cycle = 0;
        int attempt = 0;
        int attempt_letter = 0;
        for (int i = 0; i < 8; i++) {
            System.out.println("\nEnter letter:");
            letter = in.next().charAt(0);
            for (int o = 0; o < letters; o++) {
                if (letter == hiddenword.charAt(o)) {
                    word[o] = letter;
                    attempt_letter = 1;
                }
            }
            System.out.println(word);
            for (int l = 0; l < 20; l++) {
                if (letter == attempts[l]) {
                    attempt++;
                }
            }
            if (attempt > 0) {
                System.out.println("No improvements");
            }
            else if (attempt_letter == 1){
                i--;
            }
            else {
                System.out.println("That letter doesn't appear in the word");
            }
            for (int p = 0; p < letters; p++) {
                if (word[p] == hiddenword.charAt(p)) {
                    num++;
                }
            }
            if (num == letters) {
                System.out.println("You survived!");
            } else {
                num = 0;
            }
            attempts[cycle] = letter;
            cycle++;
            attempt = 0;
            attempt_letter = 0;
        }
        System.out.println("You lost!");
    }
}