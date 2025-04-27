package homeworks.ArrayList;

public class TopManager implements Employee {
    private final int SALARY = 100_000;
    Company company;
    private final int income = 0;

    public TopManager(Company company) {
        this.company = company;
    }

    public int getIncome() {
        return income;
    }

    // зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы, если доход компании более 10 млн рублей.
    @Override
    public int getMonthSalary() {
        return company.getIncome() > 10_000_000 ? (int) (SALARY * 2.5) : SALARY;
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.";
    }
}
