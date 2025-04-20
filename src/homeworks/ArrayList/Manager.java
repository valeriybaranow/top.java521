package homeworks.ArrayList;

import java.util.Random;

public class Manager implements Employee {
    private final double SALARY = 50_000;
    private final int MIN_EARNED_MONEY = 115_000;
    private final int MAX_EARNED_MONEY = 140_000;
    Company company;
    private double income;

    public Manager(Company company) {
        this.company = company;
        this.income = getEarnedMoney();
    }

    // Зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
    // Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
    @Override
    public double getMonthSalary() {
        double income = getIncome();
        company.addIncome(income);
        return SALARY + (income * 1.05);
    }


    private double getEarnedMoney() {
        Random random = new Random();
        return random.nextInt(MAX_EARNED_MONEY - MIN_EARNED_MONEY + 1) + MIN_EARNED_MONEY;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return getMonthSalary() + " руб.";
    }
}
