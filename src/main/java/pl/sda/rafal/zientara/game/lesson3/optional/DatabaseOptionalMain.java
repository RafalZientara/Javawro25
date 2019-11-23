package pl.sda.rafal.zientara.game.lesson3.optional;

import pl.sda.rafal.zientara.game.lesson3.Employee;
import pl.sda.rafal.zientara.game.lesson3.optional.model.Toy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class DatabaseOptionalMain {

    public static void main(String[] args) {
        List<Toy> toys = Arrays.asList(
                new Toy(1, "drapak"),
                new Toy(2, "mysz pluszowa"),
                new Toy(3, "kulka")//,
//                new Toy(5, "chomik sąsiada")
        );

        Optional<Toy> toyOptional = toys.stream()
                .filter(t -> t.id == 5)
                .findFirst();


//        Toy toy = toyOptional.orElse(new Toy(6, "mój chomik ;("));
        Toy hamster = toyOptional.orElseGet(new Supplier<Toy>() {
            @Override
            public Toy get() {
                System.out.println("Jade do sąsiada. Wruum!");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return new Toy(7, "chomik inne sąsiada");
            }
        });
        System.out.println(hamster);
//        Toy toy1 = toyOptional.get();//NPE!
//        System.out.println(toyOptional);
    }
}
