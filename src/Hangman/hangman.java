package Hangman;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class hangman {

    public static void main (String[] args) {

        int num = 1;

        System.out.print("HANGMAN \n" + "The game will be available soon\n");
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        words.add("python");
        words.add("java");
        words.add("javascript");
        words.add("kotlin");
        String hiddenword = words.get(random.nextInt(words.size()));
        Set<String> word = new HashSet<>();
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < hiddenword.length(); i++){
            word.add(String.valueOf(hiddenword.charAt(i)));
        }
        String replaceword;
        System.out.println(hiddenword.replaceAll("[a-zA-Z]","-"));
        for(int i = 8; i >= 1;){
            System.out.print("Input a letter:> ");
            String letter = scanner.nextLine();
            if(letters.contains(letter)){
                System.out.println("You've already guessed this letter.");
            }
            if(letter.length() > 1){
                System.out.println("You should input a single letter.");
            }
            if(word.contains(letter) && !letters.contains(letter)){
                letters.add(letter);
                replaceword = hiddenword.replaceAll("[^"+letters+"]","-");
                System.out.println(replaceword);}
            if (letter.matches("[A-Z]")){
                System.out.println("Please enter a lowercase English letter.");
            }
            if (!word.contains(letter) && letter.length() < 2){
                System.out.println("That letter doesn't appear in the word");
                i--;
            }
            if (letters.size() == word.size()) {
                System.out.println("You survived!");
                break;
            }
            if (i == 0){
                System.out.println("You lost!");
            }
        }
    }
}