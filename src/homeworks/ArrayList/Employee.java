package homeworks.ArrayList;

interface Employee extends Comparable<Employee> {
    int getMonthSalary();

    int getIncome();

    @Override
    default int compareTo(Employee o) {
        if (this.getMonthSalary() < o.getMonthSalary()) {
            return -1;
        } else if (this.getMonthSalary() > o.getMonthSalary()) {
            return 1;
        } else {
            return 0;
        }
    }
}
