package pl.sda.rafal.zientara.game.lesson3.optional;

import java.util.Optional;

public class MainOptional {

    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.ofNullable(null);

        if (stringOptional.isPresent()) {
            System.out.println(stringOptional.get());
        }

        /*String text = null;

        if(text != null) {
            System.out.println(text);
        } else {
            System.out.println("To jest null");
        }*/
    }
}
