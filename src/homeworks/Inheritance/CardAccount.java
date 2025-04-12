package homeworks.Inheritance;

public final class CardAccount extends BankAccount {
    @Override
    public boolean take(double value) {
        value *= 1.01;
        return super.take(value);
    }
}
