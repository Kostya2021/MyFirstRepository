package bank.app;

import java.util.InputMismatchException;

public class Bank {

    protected long balance;

    public long getBalance() {
        return balance;
    }

    public void deposit(long value){
        balance += value;
    }

    public void withdraw(long value) {
        balance -= value;
    }

    public void withdrawForeign(long foreignValue, double conversionfactor) {
        long convertedValue = Math.round(conversionfactor*foreignValue);
        balance -= convertedValue;
    }

    public void create(long newBalance) {
        balance = newBalance;
    }
}
