package bank.app;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс для обработки введденых в коносль данных
 */
public class Operations {
    public long value;
    protected double rate;


    public long BankSum(String arg) {

        Scanner scanner = new Scanner(System.in);


        System.out.print(arg);


        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {

            System.out.println("Unknown value for sum. Try again");
            value = 0;
        }

        return value;
    }

    public double BankRate() {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Input rate: ");


        try {

            rate = scanner.nextDouble();
        } catch (InputMismatchException e) {

            System.out.println("Unknown value for rate. Try again");
            rate = 0;
        }

        return rate;
    }
}
