package pl.sda.rafal.zientara.game.lesson3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainZad3Dod {

    public static void main(String[] args) {
        List<Employee> employee = Arrays.asList(
                new Employee("Kowal", "Jan", 34, 3400.0),
                new Employee("As", "Ala", 27, 4100.0),
                new Employee("Kot", "Zofia", 33, 3700.0),
                new Employee("Puchacz", "Jan", 41, 3600.0)
        );
        Stream<String> stringStream = employee.stream()
                .filter(emp -> emp.getAge() > 30 && emp.getSalary() < 4000)
                .peek(emp -> emp.setSalary(emp.getSalary() * 1.1))
                .map(Employee::toString);
        stringStream
                .forEach(text -> System.out.println(text));
//                .collect(Collectors.toList());
//        System.out.println(names);
    }
}
