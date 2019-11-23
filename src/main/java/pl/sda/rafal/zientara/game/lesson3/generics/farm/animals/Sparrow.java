package pl.sda.rafal.zientara.game.lesson3.generics.farm.animals;

public class Sparrow extends BirdAnimal {

    public Sparrow(String skin, String name) {
        super(skin, name);
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    String getSound() {
        return "Ćwir ćwir";
    }
}
