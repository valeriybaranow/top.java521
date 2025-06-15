package homeworks.thread.tasktwo;

public class Logger {
    public static void deposit(Cashier cashier, int amount, int balance) {
        System.out.printf("%s (пополнение): внес %d руб. Баланс: %d руб.\n", cashier, amount, balance);
    }

    public static void withdraw(Cashier cashier, int amount, int balance) {
        System.out.printf("%s (выдача): выдал %d. Баланс: %d\n", cashier, amount, balance);
    }

    public static void overflowWait(Cashier cashier, int amount) {
        System.out.printf("касса переполнена, ожидаю... (попытка добавить %d руб. кассиром %s)\n", amount, cashier);
    }

    public static void deficitWait(Cashier cashier, int amount) {
        System.out.printf("недостаточно средств, ожидаю... (попытка снять %d руб. кассиром %s)\n", amount, cashier);
    }

    public static void balanceStatus(CashRegister cashRegister) {
        System.out.printf("--- Статус: баланс %d руб., операций: %d ---\n",
                cashRegister.getBalance(),
                cashRegister.getCountOperations());
    }
}
