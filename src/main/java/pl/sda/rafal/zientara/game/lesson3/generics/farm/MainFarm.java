package pl.sda.rafal.zientara.game.lesson3.generics.farm;

import pl.sda.rafal.zientara.game.lesson3.generics.farm.animals.*;

public class MainFarm {

    public static void main(String[] args) {
        OldMcDonaldFarm<Animal> donaldFarm = new OldMcDonaldFarm<>();

        donaldFarm.addAnimal(new Cow());
        donaldFarm.addAnimal(new Dog());
        donaldFarm.addAnimal(new Chicken("pióra", "Chickoletta"));
        donaldFarm.addAnimal(new Sparrow("pióra", "Jack"));

        donaldFarm.printAllInfo();
        donaldFarm.printBirdsInfo();
        donaldFarm.printMammalsInfo();
    }
}
