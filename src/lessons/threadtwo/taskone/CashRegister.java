package lessons.threadtwo.taskone;

public class CashRegister {
    private static final int MAX_BALANCE = 1000;
    private static final int MIN_BALANCE = 0;

    private int balance = 0;
    private int contOperations = 0;

    public void deposit(Cashier cashier, int amount) {
        int newBalance = balance + amount;
        if (newBalance > MAX_BALANCE) {
            Logger.overflowWait();
        } else {
            contOperations++;
            this.balance = newBalance;
            Logger.deposit(cashier, amount, getBalance());
        }
    }

    public void withdraw(Cashier cashier, int amount) {
        int newBalance = balance - amount;
        if (newBalance < MIN_BALANCE) {
            Logger.deficitWait();
        } else {
            contOperations++;
            this.balance = newBalance;
            Logger.withdraw(cashier, amount, getBalance());
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getCountOperations() {
        return contOperations;
    }
}
