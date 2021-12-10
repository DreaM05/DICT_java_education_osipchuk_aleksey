package TicTacToe;

public class TicTacToe {

    public static void main(String[] args) {

        String[][] strings = {{"X ", "0 ", "X"},
                            {"O ", "X ", "O"},
                            {"X ", "X ", "O"}};
        for (String [] ss : strings) {
            for (String s : ss)
                System.out.print(s + "");
                System.out.println();
        }

    }

}