package pl.sda.rafal.zientara.game.lesson3.streams;

public class Employee {
    private final String surname;
    private final String name;
    private final int age;
    private double salary;

    public Employee(String surname, String name, int age, double salary) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
