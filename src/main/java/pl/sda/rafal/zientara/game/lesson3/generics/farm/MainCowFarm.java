package pl.sda.rafal.zientara.game.lesson3.generics.farm;

import pl.sda.rafal.zientara.game.lesson3.generics.MilkFactory;
import pl.sda.rafal.zientara.game.lesson3.generics.farm.animals.Cow;
import pl.sda.rafal.zientara.game.lesson3.generics.farm.animals.CowGMO;

public class MainCowFarm {

    public static void main(String[] args) {
        MilkFactory cowFarm = new MilkFactory();
        cowFarm.addAnimal(new Cow());
        cowFarm.addAnimal(new Cow("Baltora"));
        cowFarm.addAnimal(new Cow("Łatka"));
        cowFarm.addAnimal(new Cow("Milka"));
        cowFarm.addAnimal(new Cow("Miła"));
        cowFarm.addAnimal(new Cow("Krasula"));
        cowFarm.addAnimal(new CowGMO());
        cowFarm.printAllInfo();
        System.out.println("Produkcja mleka:"
                + cowFarm.produceMilk());
    }
}
