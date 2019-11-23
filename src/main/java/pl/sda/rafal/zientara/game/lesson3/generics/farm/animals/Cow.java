package pl.sda.rafal.zientara.game.lesson3.generics.farm.animals;

import java.util.Random;

public class Cow extends MammalAnimal {

    public Cow(String skin, String name) {
        super(skin, name);
    }

    public Cow(String name) {
        this("futro", name);
    }

    public Cow() {
        this("Mućka");
    }

    @Override
    String getSound() {
        return "Muuuu!";
    }

    public int getMilk() {
        return new Random()
                .nextInt(10);
    }
}
