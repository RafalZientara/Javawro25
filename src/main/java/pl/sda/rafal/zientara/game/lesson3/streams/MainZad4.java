package pl.sda.rafal.zientara.game.lesson3.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainZad4 {

    public static void main(String[] args) {
        List<String> snum = Arrays.asList("7", "20", "160", "777", "822", "888,3",
                "999,0");

        System.out.println(Math.log10(100));//2
        System.out.println(Math.log10(999));//2.9995654882259823
        List<String> strings = snum.stream()
                .map(text -> text.replace(",", "."))
                .map(Double::parseDouble)
                .filter(num -> checkNumberLength(num, 3))//3 liczby
//                .filter(num -> num < 1000 & num > 99)
//                .filter(text -> text.length() == 3)//meh 888,3
                .filter(MainZad4::isInteger)//tylko calkowite
                .filter(MainZad4::isEven)//parzyste
                .map(Double::intValue)
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(strings);
    }

    private static boolean isInteger(Double num) {
        return (num - num.intValue()) == 0;
    }

    private static boolean isEven(Double num) {
        return num % 2 == 0;
    }

    private static boolean checkNumberLength(Double num, int numberCount) {
        return (int) (Math.log10(num)) == numberCount - 1;
    }
}
