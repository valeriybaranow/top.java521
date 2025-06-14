package lessons.threadtwo.taskone;

import java.util.List;

public class WithdrawCashier extends Cashier {

    public WithdrawCashier(String name, List<Integer> sums, CashRegister cashRegister) {
        super(name, sums, cashRegister);
    }


    public void executeOperations() throws InterruptedException {
        cashRegister.lock.lock();
        try {
            for (Integer sum : sums) {
                try {
                    cashRegister.withdraw(this, sum);
                    flag++;
                    // Сигнализируем после изменения баланса
                    cashRegister.deficit.signal();
                } catch (IllegalStateException e) {
                    cashRegister.overflow.awaitUninterruptibly();
                }
            }
        } finally {
            cashRegister.lock.unlock();
        }
    }
}
