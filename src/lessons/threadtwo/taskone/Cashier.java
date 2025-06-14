package lessons.threadtwo.taskone;

import java.util.ArrayList;
import java.util.List;

public abstract class Cashier extends Thread {
    private final String cashierName;
    protected List<Integer> sums = new ArrayList<>();
    protected Integer flag = 0;
    protected CashRegister cashRegister;

    public Cashier(String name, List<Integer> sums, CashRegister cashRegister) {
        this.cashierName = name;
        this.sums = sums;
        this.cashRegister = cashRegister;
        this.setName(name);
    }

    public abstract void executeOperations() throws InterruptedException;

    public String getCashierName() {
        return cashierName;
    }

    public List<Integer> getSums() {
        return sums;
    }

    @Override
    public void run() {
        try {
            executeOperations();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return this.getCashierName();
    }
}
