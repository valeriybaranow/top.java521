package homeworks.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        final int COUNT_OPERATOR = 10;
        final int COUNT_MANAGER = 10;
        final int COUNT_IOP_MANAGER = 10;

        // подготовка
        Company company = new Company("Академия ТОП");
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


        // найм
        System.out.println("Найм в компанию " + company);
        company.hireAll(employees);
        System.out.println("Компания " + company + " наняла сотрудников");
        // вывод
        System.out.println("Список самых высоких зарплат в компании " + company);
        for (Employee employee : company.getTopSalaryStaff(10)) {
            System.out.println(employee);
        }
        System.out.println("Список самых низких зарплат в компании " + company);
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee);
        }

        // увольнение
        for (int i = 0; i < (COUNT_IOP_MANAGER + COUNT_MANAGER + COUNT_IOP_MANAGER) / 2; i++) {
            employees.remove(employees.get(i));
        }

        // вывод
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
