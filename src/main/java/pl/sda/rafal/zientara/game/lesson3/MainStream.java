package pl.sda.rafal.zientara.game.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 5);


        List<Double> output = numbers.stream()
                .map(integer -> integer / 2.)
                .map(aDouble -> aDouble * 2)
                .filter(filtr -> filtr > 4)//true/false
                .collect(Collectors.toList());
        System.out.println(output);
    }
}
