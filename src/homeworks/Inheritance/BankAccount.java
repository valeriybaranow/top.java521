package homeworks.Inheritance;

public class BankAccount {
    // сумма на счете
    private double amount = 0;

    public double getAmount() {
        return amount;
    }

    // default иди protected
    protected boolean put(double value) {
        double newAmount = amount + value;
        if (value < 0) {
            return false;
        }
        amount = newAmount;
        return true;
    }

    // default иди protected
    protected boolean take(double value) {
        double newAmount = amount - value;
        if (value < 0) {
            return false;
        }
        if (newAmount < 0) {
            return false;
        }
        amount = newAmount;
        return true;
    }
}
