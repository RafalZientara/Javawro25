package pl.sda.rafal.zientara.game.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainZad2 {

    public static void main(String[] args) {
        List<String> txt = Arrays.asList( "Ala", "samochód", "kot", "aleksandra", "pies", "azor");

        List<String> output = txt.stream()
                .filter(text -> text.startsWith("a") || text.startsWith("A"))
                .map(MainZad2::getStringWithBigLetter)
                .collect(Collectors.toList());

//        (firstPAr, secPAr, thirdPar) -> func(firstPAr, secPAr, thirdPar)
//                MainZad2::func // method reference

        System.out.println(output);

        String test = "ola";
        if (test.contains("a")) {//true
            System.out.println("Zawiera a");
        }

        if (test.charAt(0) == 'a') {
            System.out.println("Zaczyna się na a");
        }
        if (test.startsWith("al")) {
            System.out.println("Zaczyna się na \"al\"");
        }

    }

    private static String getStringWithBigLetter(String s) {
        //                        char firstLetter = s.toUpperCase().charAt(0);//meh
        char firstLetter = s.charAt(0);//OK
        firstLetter = Character.toUpperCase(firstLetter);
        String substring = s.substring(1);
        return firstLetter + substring;
    }
}
