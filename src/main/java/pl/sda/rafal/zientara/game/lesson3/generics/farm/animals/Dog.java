package pl.sda.rafal.zientara.game.lesson3.generics.farm.animals;

public class Dog extends MammalAnimal {

    public Dog(String skin, String name) {
        super(skin, name);
    }

    public Dog(String name) {
        this("futro", name);
    }

    public Dog() {
        this("Leszek");
    }

    @Override
    String getSound() {
        return "Hau hau!";
    }

}
