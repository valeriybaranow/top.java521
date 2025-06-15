package homeworks.thread.tasktwo;

import java.util.List;

public abstract class Cashier extends Thread {
    private final String cashierName;
    protected List<Integer> sums;
    protected CashRegister cashRegister;

    public Cashier(String name, List<Integer> sums, CashRegister cashRegister) {
        this.cashierName = name;
        this.sums = sums;
        this.cashRegister = cashRegister;
        this.setName(name);
    }

    public String getCashierName() {
        return cashierName;
    }

    @Override
    public String toString() {
        return this.getCashierName();
    }
}
