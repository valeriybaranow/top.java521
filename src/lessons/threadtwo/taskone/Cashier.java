package lessons.threadtwo.taskone;

import java.util.ArrayList;
import java.util.List;

public abstract class Cashier {
    private final String name;
    protected List<Integer> sums = new ArrayList<>();
    protected CashRegister cashRegister;

    public Cashier(String name, List<Integer> sums, CashRegister cashRegister) {
        this.name = name;
        this.sums = sums;
        this.cashRegister = cashRegister;
    }

    public abstract void executeOperations();

    public String getName() {
        return name;
    }

    public List<Integer> getSums() {
        return sums;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
