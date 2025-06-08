package lessons.threadtwo.taskone;

import java.util.List;

public class WithdrawCashier extends Cashier {

    public WithdrawCashier(String name, List<Integer> sums, CashRegister cashRegister) {
        super(name, sums, cashRegister);
    }

    public void executeOperations() throws InterruptedException {
        for (int i = 0; i < sums.size(); i++) {
            cashRegister.withdraw(this, sums.get(i));
        }
    }
}
