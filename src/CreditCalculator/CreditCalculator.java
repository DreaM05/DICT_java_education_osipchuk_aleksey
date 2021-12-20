package CreditCalculator;
import java.util.Scanner;
import static java.lang.Math.*;

public class CreditCalculator {
    public static void main(String[] args) {
        double principal;
        double numberPeriod;
        double mesyachniiPlatej;
        double procentyPoKreditu;
        double years;
        char parametric;
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите параметр действия, которые вы хотите сделать (a/p/n): ");
        parametric = in.next().charAt(0);
        System.out.print("Укажите процент по кредиту: ");
        procentyPoKreditu = in.nextDouble();
        procentyPoKreditu = procentyPoKreditu / (12 * 100);
        if (parametric == 'a') {
            System.out.print("Ваш ежемесячный платеж:");
            principal = in.nextDouble();
            System.out.print("Укажите кол-во периодов: ");
            numberPeriod = in.nextDouble();
            mesyachniiPlatej = principal * (procentyPoKreditu * pow(1 + procentyPoKreditu, numberPeriod)) / (pow(1 + procentyPoKreditu, numberPeriod) - 1);
            mesyachniiPlatej = ceil(mesyachniiPlatej);
            System.out.print("Ваш ежемесячный платеж составляет  = " + mesyachniiPlatej);
        } else if (parametric == 'p'){
            System.out.print("Укажите аннуитетный платеж: ");
            mesyachniiPlatej = in.nextDouble();
            System.out.print("Укажите кол-во периодов: ");
            numberPeriod = in.nextDouble();
            principal = mesyachniiPlatej * (procentyPoKreditu * pow(1 + procentyPoKreditu, numberPeriod)) / (pow(1 + procentyPoKreditu, numberPeriod) - 1);
            principal = ceil(principal);
            System.out.print("Ваш основной долг по кредиту составляет = " + principal);
        } else if (parametric == 'n') {
            System.out.print("Укажите кол-во месяцев:");
            mesyachniiPlatej = in.nextDouble();
            System.out.print("Укажите вашу сумму: ");
            principal = in.nextDouble();
            numberPeriod = log(mesyachniiPlatej / (mesyachniiPlatej - procentyPoKreditu * principal)) / log(1 + procentyPoKreditu);
            numberPeriod = ceil(numberPeriod);
            years = numberPeriod / 12;
            years = floor(years);
            System.out.print("Если возьмете" + years + "лет(год)");
            if (numberPeriod - years * 12 > 0){
                numberPeriod = numberPeriod - years * 12;
                System.out.print("и" + numberPeriod + "месяцев, чтобы погасить этот кредит");
            }
        } else {
            System.out.println("Ошибка, попробуйте еще раз!");
        }
    }

}
