package homeworks.Inheritance;

import java.util.Calendar;

public final class DepositAccount extends BankAccount {
    private Calendar lastIncome;

    @Override
    public boolean put(double value) {
        lastIncome = Calendar.getInstance();
        System.out.println(lastIncome.getTime());
        lastIncome.roll(Calendar.MONTH, -1);
        lastIncome.roll(Calendar.DATE, -1);
        System.out.println(lastIncome.getTime());
        return super.put(value);
    }

    @Override
    public boolean take(double value) {
        if (lastIncome == null) {
            return false;
        }
        Calendar lastIncomeCopy = lastIncome;
        lastIncomeCopy.roll(Calendar.MONTH, +1);
        if (lastIncomeCopy.before(Calendar.getInstance())) {
            System.out.println("You cannot withdraw money within one month after the last deposit " + lastIncome.getTime());
            return false;
        }
        return super.take(value);
    }
}
