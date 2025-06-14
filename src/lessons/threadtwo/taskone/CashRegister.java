package lessons.threadtwo.taskone;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister {
    private static final int MAX_BALANCE = 1000;
    private static final int MIN_BALANCE = 0;

    protected final ReentrantLock lock = new ReentrantLock();
    private int contOperations = 0;
    protected final Condition overflow = lock.newCondition();
    protected final Condition deficit = lock.newCondition();
    private int balance = 20;

    public void deposit(Cashier cashier, int amount) throws IllegalStateException {
        if (balance + amount > MAX_BALANCE) {
            Logger.overflowWait();
            throw new IllegalStateException("Превышение максимального баланса");
        } else {
            balance += amount;
            contOperations++;
            Logger.deposit(cashier, amount, getBalance());
        }
    }

    public void withdraw(Cashier cashier, int amount) throws InterruptedException {
        if (balance - amount < MIN_BALANCE) {
                Logger.deficitWait();
            throw new IllegalStateException("Дефицит баланса");
        } else {
            contOperations++;
            balance -= amount;
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
