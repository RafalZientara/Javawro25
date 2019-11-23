package pl.sda.rafal.zientara.game.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainFlatMap {

    public static void main(String[] args) {
        List<String> snum = Arrays.asList("ala ma kota", "kot", "ma ", "Ale");
//        Integer[] ints = new Integer[3];
//        Arrays.stream(ints)

        List<String> collect = snum.stream()
                .flatMap(text -> Arrays.stream(text.split(" ")))
                .collect(Collectors.toList());

        for (String text : collect) {
            System.out.println("#" + text + "#");
        }

    }
}
