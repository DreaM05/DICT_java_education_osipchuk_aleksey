package CreditCalculator;

import static java.lang.Math.*;

public class CreditCalculator {

    public static void main(String[] args) {

        double principal;
        double numberPeriod;
        double mesyachniiPlatej;
        double procentyPoKreditu;
        double years;
        double D_m;
        double Pereplata = 0;

        String type = System.getProperty("type");
        String consoleNachisleniaProcPoKreditu = System.getProperty("interest");
        String principalConsole = System.getProperty("principal");
        String periodsConsole = System.getProperty("periods");
        String consoleMesyachnyhPlatejei = System.getProperty("payment");

        if (type == null) {
            System.out.println("Неправильные параметры.");
        } else if (consoleNachisleniaProcPoKreditu == null) {
            System.out.println("Неправильные параметры.\n");
        } else if (type.equals("annuity")) {
            procentyPoKreditu = Double.parseDouble(consoleNachisleniaProcPoKreditu);
            procentyPoKreditu = procentyPoKreditu / (12 * 100);
            if (principalConsole != null && periodsConsole != null) {
                principal = Double.parseDouble(principalConsole);
                numberPeriod = Double.parseDouble(periodsConsole);

                mesyachniiPlatej = principal * (procentyPoKreditu * pow(1 + procentyPoKreditu, numberPeriod)) / (pow(1 + procentyPoKreditu, numberPeriod) - 1);
                mesyachniiPlatej = ceil(mesyachniiPlatej);
                System.out.println("Ваш ежемесячный платеж = " + mesyachniiPlatej);
            } else if (consoleMesyachnyhPlatejei != null && periodsConsole != null) {
                mesyachniiPlatej = Double.parseDouble(consoleMesyachnyhPlatejei);
                numberPeriod = Double.parseDouble(periodsConsole);

                principal = mesyachniiPlatej / ((procentyPoKreditu * pow(1 + procentyPoKreditu, numberPeriod)) / (pow(1 + procentyPoKreditu, numberPeriod) - 1));
                principal = ceil(principal);
                System.out.println("Ваш основной долг по кредиту = " + principal);
            } else if (consoleMesyachnyhPlatejei != null && principalConsole != null) {
                mesyachniiPlatej = Double.parseDouble(consoleMesyachnyhPlatejei);
                principal = Double.parseDouble(principalConsole);
                numberPeriod = log(mesyachniiPlatej / (mesyachniiPlatej - procentyPoKreditu * principal)) / log(1 + procentyPoKreditu);
                numberPeriod = ceil(numberPeriod);
                years = numberPeriod / 12;
                years = floor(years);
                System.out.print("Если возьмете " + years + " лет(год)");
                if (numberPeriod - years * 12 > 0) {
                    numberPeriod = numberPeriod - years * 12;
                    System.out.print(" и " + numberPeriod + "месяцев, чтобы погасить этот кредит!");
                }
            } else {
                System.out.println("Неправильные параметры.");
            }
        } else if (type.equals("diff")) {
            procentyPoKreditu = Double.parseDouble(consoleNachisleniaProcPoKreditu);
            procentyPoKreditu = procentyPoKreditu / (12 * 100);
            if (principalConsole == null || periodsConsole == null){
                System.out.println("Неправильные параметры.");
            }
            else {
                principal = Double.parseDouble(principalConsole);
                numberPeriod = Double.parseDouble(periodsConsole);
                for (int m = 1; m <= numberPeriod; m++) {
                    D_m = principal / numberPeriod + procentyPoKreditu * (principal - (principal * (m - 1)) / numberPeriod);
                    D_m = ceil(D_m);
                    Pereplata = Pereplata + (D_m - (principal / numberPeriod));
                    System.out.println("Вы должны заплатить за " + numberPeriod + " месяца(ев). Оплата составляет " + D_m);
                }
                System.out.println("Переплата = " + Pereplata);
            }
        } else {
            System.out.println("Ошибка, попробуйте еще раз!");
            System.out.println("Неправильные параметры.");
        }
    }
}
