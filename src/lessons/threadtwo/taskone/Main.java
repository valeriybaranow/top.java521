package lessons.threadtwo.taskone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        List<Cashier> cashiers = new ArrayList<Cashier>();

        List<Integer> sums = Arrays.asList(10, 20, 30, 40, 50, 60);
        cashiers.add(new WithdrawCashier("Кассир 1", sums, cashRegister));
        cashiers.add(new WithdrawCashier("Кассир 2", sums, cashRegister));
        cashiers.add(new WithdrawCashier("Кассир 3", sums, cashRegister));
        cashiers.add(new DepositCashier("Кассир 4", sums, cashRegister));
        cashiers.add(new DepositCashier("Кассир 5", sums, cashRegister));

        System.out.println("Start");
        cashiers.forEach(cashier -> {
            cashier.start();
            System.out.println("Thread " + cashier.getName());
            try {
                cashier.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("End");
    }
}
