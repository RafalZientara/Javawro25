package pl.sda.rafal.zientara.game.lesson3.generics.farm.animals;

public class Chicken extends BirdAnimal {

    public Chicken(String skin, String name) {
        super(skin, name);
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    String getSound() {
        return "Ko";
    }
}
