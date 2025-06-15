package homeworks.thread.tasktwo;

import java.util.List;

public class DepositCashier extends Cashier {
    public DepositCashier(String name, List<Integer> sums, CashRegister cashRegister) {
        super(name, sums, cashRegister);
    }

    @Override
    public void run() {
        for (Integer sum : sums) {
            cashRegister.deposit(this, sum);
        }
    }
}
