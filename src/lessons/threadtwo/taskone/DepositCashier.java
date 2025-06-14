package lessons.threadtwo.taskone;

import java.util.List;

public class DepositCashier extends Cashier {
    public DepositCashier(String name, List<Integer> sums, CashRegister cashRegister) {
        super(name, sums, cashRegister);
    }

    public void executeOperations() throws InterruptedException {
        cashRegister.lock.lock();
        try {
            for (Integer sum : sums) {
                try {
                    cashRegister.deposit(this, sum);
                    // Сигнализируем после изменения баланса
                    cashRegister.overflow.signal();
                } catch (IllegalStateException e) {
                    cashRegister.deficit.awaitUninterruptibly();
                }
            }
        } finally {
            cashRegister.lock.unlock();
        }
    }
}
