package homeworks.thread.tasktwo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CashRegister {
    private static final int MAX_BALANCE = 1000;
    private static final int MIN_BALANCE = 0;

    protected final ReentrantLock lock = new ReentrantLock();
    protected final Condition overflow = lock.newCondition();
    protected final Condition deficit = lock.newCondition();
    private int contOperations = 0;
    private int balance = 0;

    public void deposit(Cashier cashier, int amount) {
        lock.lock();
        try {
            while (balance + amount > MAX_BALANCE) {
                Logger.overflowWait(cashier, amount);
                overflow.await();
            }
            balance += amount;
            contOperations++;
            Logger.deposit(cashier, amount, getBalance());
            if (contOperations % 10 == 0) {
                Logger.balanceStatus(this);
            }
            overflow.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(Cashier cashier, int amount) {
        try {
            lock.lock();
            while (balance - amount < MIN_BALANCE) {
                Logger.deficitWait(cashier, amount);
                overflow.await();
            }
            contOperations++;
            balance -= amount;
            Logger.withdraw(cashier, amount, getBalance());
            if (contOperations % 10 == 0) {
                Logger.balanceStatus(this);
            }
            overflow.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
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
