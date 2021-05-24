package bank.app;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int userSelection;


        Bank bank = new Bank();

        Operations operation = new Operations();

        do {
            userSelection = MenuItems();

            switch (userSelection) {
                case 1:
                    System.out.println("Your balance is: " + bank.getBalance());

                    break;
                case 2:
                    long sumAdd = operation.BankSum("Input sum for replenish: ");

                    bank.deposit(sumAdd);

                    System.out.println("Your new balance is: " + bank.getBalance());


                    break;
                case 3:
                    long sumDraw = operation.BankSum("Input sum for draw: ");

                    bank.withdraw(sumDraw);

                    System.out.println("Rest balance is: " + bank.getBalance());


                    break;
                case 4:
                    long sumForeign = operation.BankSum("Input sum for draw: ");

                    double rate = operation.BankRate();


                    bank.withdrawForeign(sumForeign, rate);

                    System.out.println("Rest balance is: " + bank.getBalance());


                    break;
                case 5:
                    long newBalance = operation.BankSum("Input sum for create: ");

                    bank.create(newBalance);

                    System.out.println("Your new balance is: " + bank.getBalance());


                    break;
                case 6:
                    System.out.println("Goodbye!");

                    System.exit(0);


                    break;
                default:
                    System.out.println("Unknown operation. Try again");


                    break;
            }
        } while (userSelection < 6);
    }

    public static int MenuItems() {
        int selection;

        char[] divider = {'-'};
        String divide = new String(divider).repeat(30);


        Scanner scanner = new Scanner(System.in);

        System.out.println(divide);
        System.out.println("OPERATIONS");
        System.out.println(divide);
        System.out.println("1. Show balance");
        System.out.println("2. Replenish the balance");
        System.out.println("3. Withdraw");
        System.out.println("4. Withdraw in foreign");
        System.out.println("5. Create account");
        System.out.println("6. Exit");
        System.out.println(divide);

        System.out.print("Select operation: ");


        try {
            /** метод scanner.nextInt() отлавливает только целые числа, которые ввели в консоль, иначе будет ошибка */
            selection = scanner.nextInt();
        } catch (InputMismatchException e) {
            /** Раз возникла ошибка, то значит считаем, что ничего не ввели в консоле */
            selection = 0;
        }

        return selection;
    }
}
