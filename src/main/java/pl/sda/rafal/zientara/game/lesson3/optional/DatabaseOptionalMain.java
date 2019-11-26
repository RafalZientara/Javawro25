package pl.sda.rafal.zientara.game.lesson3.optional;

import pl.sda.rafal.zientara.game.lesson3.optional.model.Toy;

import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
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
                return new Toy(7, "chomik innego sąsiada");
            }
        });
        System.out.println(hamster);
//        Toy toy1 = toyOptional.get();//NPE!
//        System.out.println(toyOptional);
        try {
            Toy toy = toyOptional.orElseThrow(() -> new NoToyException());
            System.out.println(toy);
        } catch (NoToyException notFound) {
            notFound.printStackTrace();
            System.out.println("Nie ma takiego produktu!");
        }
    }
}
