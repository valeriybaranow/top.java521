package homeworks.ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Company {

    private final int MIN_EARNED_MONEY = 115_000;
    private final int MAX_EARNED_MONEY = 140_000;

    private final List<Employee> employees = new ArrayList<>();
    // доход компании
    private int income;
    private final String name;

    public Company(String $name) {
        this.name = $name;
    }

    // Возвращающие список указанной длины (count).
    // Они должны содержать сотрудников, отсортированных по возрастанию заработной платы
    List<Integer> getTopSalaryStaff(int count) {
        int correctedCount = Math.min(count, employees.size());
        List<Integer> monthSalaries =  new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            monthSalaries.add(employee.getMonthSalary());
        }
        monthSalaries.sort(Comparator.reverseOrder());
        return monthSalaries.subList(0, correctedCount);
    }

    // Возвращающие список указанной длины (count).
    // Они должны содержать сотрудников, отсортированных по убыванию заработной платы
    List<Integer> getLowestSalaryStaff(int count) {
        int correctedCount = Math.min(count, employees.size());
        List<Integer> monthSalaries =  new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            monthSalaries.add(employee.getMonthSalary());
        }
        monthSalaries.sort(Comparator.naturalOrder());
        return monthSalaries.subList(0, correctedCount);
    }

    // найм одного сотрудника
    public void hire(Employee employee) {
        employees.add(employee);
        income += employee.getIncome();
    }

    //  найм списка сотрудников
    public void hireAll(List<Employee> employees) {
        this.employees.addAll(employees);
        recalculateIncome(employees);
    }

    public int getEarnedMoney() {
        Random random = new Random();
        return random.nextInt(MAX_EARNED_MONEY - MIN_EARNED_MONEY + 1) + MIN_EARNED_MONEY;
    }

    public void recalculateIncome(List<Employee> employees) {
        for(Employee employee : employees) {
            income += employee.getIncome();
        }
    }

    // увольнение сотрудника
    public void fire(Employee employee) {
        income -= employee.getIncome();
        this.employees.remove(employee);
    }

    // получение значения дохода компании
    public int getIncome() {
        return income;
    }

    public void addIncome(int income) {
        this.income += income;
    }

    @Override
    public String toString() {
        return "Компания " + name + "; количество сотрудников - " + employees.size() +
                " доход - " + income;
    }
}
