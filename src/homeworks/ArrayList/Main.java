package homeworks.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

/*
    1. Создайте класс компании Company, содержащей сотрудников и реализующей методы:
    - найм одного сотрудника — hire(Employee employee),
    - найм списка сотрудников – hireAll(Collection<Employee> employes),
    - увольнение сотрудника – fire(Employee employee),
    - получение значения дохода компании – getIncome().
    Каждый метод НЕ должен иметь модификатор static, это позволит каждому объекту класса Company иметь свой набора сотрудников, свой расчет дохода, увольнение и найм.
    Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.
 */
public class Main {
    public static void main() {
        final int COUNT_OPERATOR = 180;
        final int COUNT_MANAGER = 80;
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
        System.out.println("1. Создана компания: " + company);
        company.hireAll(employees);
        System.out.println("2. Прошел найм в компанию: " + company);
        // вывод
        System.out.println("3. Список самых высоких и самых низких зарплат в компании");
        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(30));

        // увольнение
        for (int i = 0; i < (COUNT_OPERATOR + COUNT_MANAGER + COUNT_IOP_MANAGER) / 2; i++) {
            company.fire(employees.get(i));
        }
        System.out.println("4. Прошло увольнение 50% сотрудников: " + company);

        // вывод
        System.out.println("5. Список самых высоких и самых низких зарплат в компании");
        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(30));
    }
}
