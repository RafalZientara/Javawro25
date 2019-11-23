package pl.sda.rafal.zientara.game.lesson3.optional;

import pl.sda.rafal.zientara.game.lesson3.streams.Employee;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
