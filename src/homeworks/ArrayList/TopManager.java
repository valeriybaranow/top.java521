package homeworks.ArrayList;

public class TopManager implements Employee {
    private final double SALARY = 100_000;
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    // зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
    @Override
    public double getMonthSalary() {
        return company.getIncome() > 10_000_000 ? SALARY * 2.5 : SALARY;
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.";
    }
}
