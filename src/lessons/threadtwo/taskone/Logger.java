package lessons.threadtwo.taskone;

public class Logger {
    public static void deposit(Cashier cashier, int amount, int balance) {
        System.out.printf("%s (пополнение): внес %d. Баланс: %d\n", cashier, amount, balance);
    }

    public static void withdraw(Cashier cashier, int amount, int balance) {
        System.out.printf("%s (выдача): выдал %d. Баланс: %d\n", cashier, amount, balance);
    }

    public static void overflowWait() {
        System.out.printf(" касса переполнена, ожидаю...\n");
    }

    public static void deficitWait() {
        System.out.printf("недостаточно средств, ожидаю...\n");
    }

    public static void balanceStatus(CashRegister cashRegister) {
        System.out.printf("--- Статус: баланс %d, операций: %d ---\n",
                cashRegister.getBalance(),
                cashRegister.getCountOperations());
    }
}
