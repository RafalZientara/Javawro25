package pl.sda.rafal.zientara.game.lesson3.optional;

import java.util.Optional;

public class CreateOptionalMain {

    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
        Optional<String> nonNullOptional = Optional.of("tekst nigdy null");
        Optional<Object> nullableOptional = Optional.ofNullable(null);

        boolean present = empty.isPresent();
//        empty.map()
    }
}
