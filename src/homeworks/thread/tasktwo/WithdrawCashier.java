package homeworks.thread.tasktwo;

import java.util.List;

public class WithdrawCashier extends Cashier {

    public WithdrawCashier(String name, List<Integer> sums, CashRegister cashRegister) {
        super(name, sums, cashRegister);
    }

    @Override
    public void run() {
        for (Integer sum : sums) {
            cashRegister.withdraw(this, sum);
        }
    }
}
