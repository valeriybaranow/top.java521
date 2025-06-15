package homeworks.thread.tasktwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        List<Cashier> cashiers = new ArrayList<Cashier>();

        List<Integer> sums = Arrays.asList(10, 20, 30, 40, 50, 60);
        cashiers.add(new WithdrawCashier("Кассир 1", Arrays.asList(100, 200, 300, 400, 500, 50), cashRegister));
        cashiers.add(new WithdrawCashier("Кассир 2", Arrays.asList(10, 20, 30, 40, 50, 60), cashRegister));
        cashiers.add(new WithdrawCashier("Кассир 3", Arrays.asList(100, 200, 300, 400, 500, 60), cashRegister));
        cashiers.add(new DepositCashier("Кассир 4", Arrays.asList(100, 200, 300, 400, 500, 600), cashRegister));
        cashiers.add(new DepositCashier("Кассир 5", Arrays.asList(50, 200, 700, 40, 500, 60), cashRegister));

        System.out.println("Start");
        // Запускаем все потоки
        cashiers.forEach(Thread::start);

        // Ожидаем завершения всех потоков
        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Восстанавливаем флаг прерывания
                System.err.println("Main thread was interrupted");
                break;
            }
        }
        System.out.println("Количество успешных операций: " + cashRegister.getCountOperations());
        System.out.println("End");
    }
}
