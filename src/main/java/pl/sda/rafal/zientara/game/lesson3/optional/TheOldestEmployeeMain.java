package pl.sda.rafal.zientara.game.lesson3.optional;

import pl.sda.rafal.zientara.game.lesson3.streams.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TheOldestEmployeeMain {

    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(
//                new Employee("Kowal", "Jan", 34, 3400.0),
//                new Employee("As", "Ala", 27, 4100.0),
//                new Employee("Kot", "Zofia", 33, 3700.0),
//                new Employee("Puchacz", "Jan", 41, 3600.0)
        );

        Optional<Employee> max = employee.stream()
                .max(new EmployeeAgeComparator());
        /*.max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                });*/

        System.out.println(max);
    }
}
