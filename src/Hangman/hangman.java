package Hangman;

import java.util.Scanner;

public class hangman {

    public static void main (String[] args) {

        System.out.print("HANGMAN \n" + "The game will be available soon\n");
        Scanner scanner = new Scanner(System.in);
        String word = "java";
        System.out.print("Guess the word: ");
        String variant = scanner.nextLine();
        if (word.equals(variant)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }


//        switch (word) {
//            case variant:
//                System.out.println("You survived!");
//                break;
//            default:
//                System.out.println("You lost!");
//                break;
//        }





    }

}
