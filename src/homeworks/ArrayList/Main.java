package homeworks.ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int COUNT_OPERATOR = 180;
        final int COUNT_MANAGER = 80;
        final int COUNT_IOP_MANAGER = 10;
        Company company = new Company();
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < COUNT_OPERATOR; i++) {
            employees.add(new Operator());
        }
        for (int i = 0; i < COUNT_MANAGER; i++) {
            employees.add(new Manager(company));
        }
        for (int i = 0; i < COUNT_IOP_MANAGER; i++) {
            employees.add(new TopManager(company));
        }
        // перемешать или рандомизировать
        Collections.shuffle(employees);
        company.hireAll(employees);
        System.out.println("Доход компании " + company.getIncome());

        System.out.println("Список самых высоких зарплат в компании " + company);
        for (Employee employee : company.getTopSalaryStaff(10)) {
            System.out.println(employee);
        }
        System.out.println("Список самых низких зарплат в компании " + company);
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee);
        }
        for (int i = 0; i < (COUNT_IOP_MANAGER + COUNT_MANAGER + COUNT_IOP_MANAGER) / 2 ; i++) {
            employees.remove(employees.get(i));
        }
        System.out.println("Список самых высоких зарплат в компании " + company);
        for (Employee employee : company.getTopSalaryStaff(10)) {
            System.out.println(employee);
        }
        System.out.println("Список самых низких зарплат в компании " + company);
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee);
        }
    }
}
