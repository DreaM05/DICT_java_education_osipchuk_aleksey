package CreditCalculator;


import java.util.Scanner;
import static java.lang.Math.ceil;

public class CreditCalculator {

    public static void main(String[] args) {
        double principal;
        double months;
        double monthly_payments;
        char parametric;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите вашу сумму: ");
        principal = in.nextInt();
        System.out.print("Укажите параметр действия, которые вы хотите сделать (m/n): ");
        parametric = in.next().charAt(0);
        if (parametric == 'm') {
            System.out.print("Ваш ежемесячный платеж:");
            monthly_payments = in.nextInt();
            months = principal / monthly_payments;
            months = ceil(months);
            System.out.println("Вы должны будете заплатить за" + months + "месяц(а)");
        } else if (parametric == 'p') {
            System.out.print("Укажите кол-во месяцев:");
            months = in.nextInt();
            monthly_payments = principal / months;
            monthly_payments = ceil(monthly_payments);

            System.out.print("Ваш ежемесячный платеж = " + monthly_payments);
            if (principal - (monthly_payments * months) < 0) {
                monthly_payments = principal - (monthly_payments * (months - 1));
                System.out.println("Последний платеж составляет = " + monthly_payments);
            }
        } else {
            System.out.println("Ошибка, попробуйте еще раз!");
        }
    }

}
