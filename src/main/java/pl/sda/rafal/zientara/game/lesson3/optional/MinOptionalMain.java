package pl.sda.rafal.zientara.game.lesson3.optional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MinOptionalMain {

    public static void main(String[] args) {
        List<Integer> liczby = Arrays.asList(1, 3, 4, 10, 9, 13, 6);
        Optional<Integer> min = liczby.stream()
                .min(Integer::compare);
//                .min((o1, o2) -> Integer.compare(o1, o2));
        /*
                .min(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return Integer.compare(o1, o2);
                    }
                });*/

        System.out.println(min);
    }
}
