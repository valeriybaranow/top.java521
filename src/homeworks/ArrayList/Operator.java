package homeworks.ArrayList;

public class Operator implements Employee {
    private final int SALARY = 30_000;
    private final int income = 0;

    public int getIncome() {
        return income;
    }

    // зарплата складывается только из фиксированной части
    @Override
    public int getMonthSalary() {
        return SALARY;
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.";
    }
}
