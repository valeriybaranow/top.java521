package homeworks.ArrayList;

public class Operator implements Employee {
    private final double SALARY = 30_000;

    // зарплата складывается только из фиксированной части
    @Override
    public double getMonthSalary() {
        return SALARY;
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.";
    }
}
