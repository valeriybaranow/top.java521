package homeworks.ArrayList;

interface Employee extends Comparable<Employee> {
    double getMonthSalary();

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
