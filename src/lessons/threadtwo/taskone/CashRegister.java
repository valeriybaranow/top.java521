package lessons.threadtwo.taskone;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister {
    private static final int MAX_BALANCE = 1000;
    private static final int MIN_BALANCE = 0;

    private int balance = 0;
    private int contOperations = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition overflow = lock.newCondition();
    private final Condition deficit = lock.newCondition();

    public void deposit(Cashier cashier, int amount) throws InterruptedException {
        lock.lock();
        int newBalance = balance + amount;
        try {
            while (newBalance > MAX_BALANCE) {
                Logger.deposit(cashier, amount, getBalance());
                Logger.overflowWait();
                overflow.await(); // Освобождает lock и ждет
            }
            // Условие выполнено, продолжаем работу
            contOperations++;
            this.balance = newBalance;
            Logger.deposit(cashier, amount, getBalance());
            deficit.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(Cashier cashier, int amount) throws InterruptedException {
        lock.lock();
        int newBalance = balance - amount;
        try {
            while (newBalance < MIN_BALANCE) {
                Logger.withdraw(cashier, amount, getBalance());
                Logger.deficitWait();
                deficit.await(); // Освобождает lock и ждет
                System.out.println("Поток пробудился");
            }
            // Условие выполнено, продолжаем работу
            contOperations++;
            this.balance = newBalance;
            Logger.withdraw(cashier, amount, getBalance());
            overflow.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getCountOperations() {
        return contOperations;
    }
}
