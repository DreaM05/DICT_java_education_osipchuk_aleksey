package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static final String PUSTAYA = " _ ", KRESTIK = " X ", NOLIK = " O ";
    public static String aktivnyiIgrok;

    public static final int RYADKOV = 3, STOLBIKOV = 3;
    public static String[][] setka = new String[RYADKOV][STOLBIKOV];
    public static int statusIgry;
    public static final int STATUS_IGRA_PRODOLJAETSYA = 0, STATUS_NICHIYA = 1, STATUS_POBEDA_X = 2, STATUS_POBEDA_O = 3;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {    }
    public static void NachaloIgry(){    }
    public static void VvodIgroka(){}
    public static void AnalizSetki(){}
    public static boolean ProverkaZapolneniyaKletochek(){}
    public static String ProverkaPobeditelya(){}
    public static void VyvodSetki(){
        for (int ryad = 0; ryad < RYADKOV; ryad++) {
            for (int stolb = 0; stolb < STOLBIKOV; stolb++) {
                System.out.print(setka[ryad][stolb]);
                if (stolb != STOLBIKOV) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (ryad != RYADKOV - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

}