package homeworks.ArrayList;

public class Manager implements Employee {
    private final int SALARY = 50_000;
    Company company;
    private final int income;

    private boolean isWork;

    public Manager(Company company) {
        this.company = company;
        this.income = company.getEarnedMoney();
        this.isWork = false;
    }

    public int getIncome() {
        return income;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean isWork) {
        this.isWork = isWork;
    }

    // Зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
    // Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
    @Override
    public int getMonthSalary() {
        int income = getIncome();
        company.addIncome(income);
        return (int) (SALARY + (income * 1.05));
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.";
    }
}
