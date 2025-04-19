package homeworks.ArrayList;

interface Employee extends Comparable<Employee> {
    double getMonthSalary();

    @Override
    default int compareTo(Employee o) {
        if (this.getMonthSalary() == o.getMonthSalary()) {
            return 0;
        }
        return this.getMonthSalary() > o.getMonthSalary() ? 1 : 0;
    }
}
