package homeworks.Incaptulation;

public class ChildBankAccount {
    // баланс денег не счету
    private double balance;
    // максимально возможный баланс:
    private final double maxBalance;

    public ChildBankAccount(double maxBalance) {
        this.maxBalance = maxBalance;
    }

    public double getBalance() {
        return balance;
    }

    // метод пополнения карточного счёта с параметром value, содержащим количество денег, на которое необходимо пополнить счёт:
    public boolean depositMoney(double value) {
        double newBalance = balance + value;
        if (newBalance > maxBalance) {
            return false;
//            throw new Exception(String.format("Невозможно внести укащанную сумму %d на счет, т. к. после пополнения сумма на счете (сейчас - %d) превысим максимальнго возможный баланс %d", value, balance, maxBalance));
        }
        if (value < 0) {
            return false;
        }
        balance = newBalance;
        return true;
    }

    // метод списания денег со счёта:
    public boolean debitMoney(double value) {
        double newBalance = balance - value;
        if (newBalance < 0) {
            return false;
//            throw new Exception(String.format("Невозможно внести укащанную сумму %d на счет, т. к. после пополнения сумма на счете (сейчас - %d) превысим максимальнго возможный баланс %d", value, balance, maxBalance));
        }
        if (value < 0) {
            return false;
        }
        balance = newBalance;
        return true;
    }


}
