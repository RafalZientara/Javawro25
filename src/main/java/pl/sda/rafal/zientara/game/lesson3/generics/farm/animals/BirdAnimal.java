package pl.sda.rafal.zientara.game.lesson3.generics.farm.animals;

public abstract class BirdAnimal extends Animal {

    public BirdAnimal(String skin, String name) {
        super(skin, name);
    }

    public void fly() {
        if(canFly()) {
            System.out.println("Latam");
        } else {
            System.out.println("Ptak nielot");
        }
    }

    public abstract boolean canFly();

}
