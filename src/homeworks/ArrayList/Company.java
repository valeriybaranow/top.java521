package homeworks.ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/*
    1. Создайте класс компании Company, содержащей сотрудников и реализующей методы:
    - найм одного сотрудника — hire(Employee employee),
    - найм списка сотрудников – hireAll(Collection<Employee> employes),
    - увольнение сотрудника – fire(Employee employee),
    - получение значения дохода компании – getIncome().
    Каждый метод НЕ должен иметь модификатор static, это позволит каждому объекту класса Company иметь свой набора сотрудников, свой расчет дохода, увольнение и найм.
    Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.
 */
public class Company {
    private final List<Employee> employees = new ArrayList<>();
    // доход компании
    private int income;
    private String name;

    public Company(String $name) {
        this.name = $name;
    }

    // Возвращающие список указанной длины (count).
    // Они должны содержать сотрудников, отсортированных по возрастанию заработной платы
    List<Employee> getTopSalaryStaff(int count) {
        List<Employee> copy = new ArrayList<>(employees);
        copy.sort(Comparator.naturalOrder());
        System.out.println(copy);
        return copy.subList(0, count);
    }

    // Возвращающие список указанной длины (count).
    // Они должны содержать сотрудников, отсортированных по убыванию заработной платы
    List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> copy = new ArrayList<>(employees);
        copy.sort(Comparator.reverseOrder());
        return employees.subList(0, count);
    }

    // найм одного сотрудника
    public void hire(Employee employee) {
        employees.add(employee);
    }

    //  найм списка сотрудников
    public void hireAll(Collection<Employee> employes) {
        // TODO: нужно сделать расчет дохода компании
        this.employees.addAll(employes);
    }

    // увольнение сотрудника
    public void fire(Employee employee) {
        this.employees.remove(employee);
    }

    // получение значения дохода компании
    public double getIncome() {
        return income;
    }

    public void addIncome(double income) {
        this.income += income;
    }

    @Override
    public String toString() {
        return "Компания " + name + " количество сотрудников - " + employees.size() +
                " доход=" + income;
    }
}
