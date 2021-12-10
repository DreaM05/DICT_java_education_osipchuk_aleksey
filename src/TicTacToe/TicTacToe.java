package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    public static final String PUSTAYA = " _ ", KRESTIK = " X ", NOLIK = " O ";
    public static String aktivnyiIgrok;

    public static final int RYADKOV = 3, STOLBIKOV = 3;
    public static String[][] setka = new String[RYADKOV][STOLBIKOV];
    public static int statusIgry;
    public static final int STATUS_IGRA_PRODOLJAETSYA = 0, STATUS_NICHYA = 1, STATUS_POBEDA_X = 3, STATUS_POBEDA_O = 4;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        NachaloIgry();
        do {
            VvodIgroka();
            AnalizSetki();
            VyvodSetki();
            if (statusIgry == STATUS_POBEDA_X) {
                System.out.println("'X' побеждает!");
            } else if (statusIgry == STATUS_POBEDA_O) {
                System.out.println("'O' побеждает!");
            } else if (statusIgry == STATUS_NICHYA) {
                System.out.println("Игра закончилась в ничью!");
            }
            aktivnyiIgrok = (aktivnyiIgrok == KRESTIK?NOLIK:KRESTIK);
        }
        while (statusIgry == STATUS_IGRA_PRODOLJAETSYA);
    }

    public static void NachaloIgry(){
        for (int ryad = 0; ryad < RYADKOV; ryad++) {
            for (int stolb = 0; stolb < STOLBIKOV; stolb++) {
                setka[ryad][stolb] = PUSTAYA;
            }
        }
        aktivnyiIgrok = KRESTIK;
        VyvodSetki();
    }

    public static void VvodIgroka(){
        boolean vvodDejstvitelen = false;
        do {
            System.out.println("Игрок '" + aktivnyiIgrok + "', введите ряд (1-3) и столбец (1-3) через пробел: ");
            int ryad = in.nextInt() - 1;
            int stolb = in.nextInt() - 1;
            if (ryad >= 0 && ryad < RYADKOV && stolb >= 0 && stolb < STOLBIKOV && setka[ryad][stolb] == PUSTAYA) {
                setka[ryad][stolb] = aktivnyiIgrok;
                vvodDejstvitelen = true;
            } else {
                System.out.println("Выбранная позиция (" + (ryad + 1) + "," + (stolb + 1) + ") не может быть использована. Попробуйте снова...");
            }
        } while (!vvodDejstvitelen);
    }

    public static void AnalizSetki(){
        String pobeditel = ProverkaPobeditelya();
        if (pobeditel.equals(KRESTIK)) {
            statusIgry = STATUS_POBEDA_X;
        } else if (pobeditel.equals(NOLIK)) {
            statusIgry = STATUS_POBEDA_O;
        } else if (ProverkaZapolneniyaKletochek()) {
            statusIgry = STATUS_NICHYA;
        } else {
            statusIgry = STATUS_IGRA_PRODOLJAETSYA;
        }
    }

    public static boolean ProverkaZapolneniyaKletochek(){
        for (int ryad = 0; ryad < RYADKOV; ryad++) {
            for (int stolb = 0; stolb < STOLBIKOV; stolb++) {
                if (setka[ryad][stolb] == PUSTAYA) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String ProverkaPobeditelya(){
        int odinakovye;
        // 3 в ряд
        for (int ryad = 0; ryad < RYADKOV; ryad++) {
            odinakovye = 0;
            for (int stolb = 0; stolb < STOLBIKOV; stolb++) {
                if (setka[ryad][0] != PUSTAYA && setka[ryad][0] == setka[ryad][stolb]) {
                    odinakovye++;
                }
            }
            if (odinakovye == 3) {
                return setka[ryad][0];
            }
        }
        // 3 в столбец
        for (int stolb = 0; stolb < RYADKOV; stolb++) {
            odinakovye = 0;
            for (int ryad = 0; ryad < STOLBIKOV; ryad++) {
                if (setka[0][stolb] != PUSTAYA && setka[0][stolb] == setka[ryad][stolb]) {
                    odinakovye++;
                }
            }
            if (odinakovye == 3) {
                return setka[0][stolb];
            }
        }
        // 3 по диагонали справа налево
        if (setka[0][0] != PUSTAYA && setka[0][0] == setka[1][1] && setka[0][0] == setka[2][2]) {
            return setka[0][0];
        }
        // 3 по диагонали слева направа
        if (setka[0][2] != PUSTAYA && setka[1][1] == setka[0][2] && setka[2][0] == setka[2][0]) {
            return setka[0][2];
        }
        return PUSTAYA;
    }

    public static void VyvodSetki(){
        for (int ryad = 0; ryad < RYADKOV; ryad++) {
            for (int stolb = 0; stolb < STOLBIKOV; stolb++) {
                System.out.print(setka[ryad][stolb]);
                if (stolb != STOLBIKOV - 1) {
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