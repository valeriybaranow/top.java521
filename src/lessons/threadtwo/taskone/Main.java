package lessons.threadtwo.taskone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        List<Cashier> cashiers = new ArrayList<Cashier>();

        List<Integer> sums = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800, 900, 1000);
        cashiers.add(new WithdrawCashier("Кассир 1", sums, cashRegister));
        cashiers.add(new WithdrawCashier("Кассир 2", sums, cashRegister));
        cashiers.add(new WithdrawCashier("Кассир 2", sums, cashRegister));
        cashiers.add(new DepositCashier("Кассир 2", sums, cashRegister));
        cashiers.add(new DepositCashier("Кассир 2", sums, cashRegister));

        cashiers.stream().forEach(cashier -> cashier.executeOperations());
    }
}
