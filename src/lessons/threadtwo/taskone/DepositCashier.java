package lessons.threadtwo.taskone;

import java.util.List;

public class DepositCashier extends Cashier {

    public DepositCashier(String name, List<Integer> sums, CashRegister cashRegister) {
        super(name, sums, cashRegister);
    }

    public void executeOperations() throws InterruptedException {
        for (int i = 0; i < sums.size(); i++) {
            cashRegister.deposit(this, sums.get(i));
        }
    }
}
