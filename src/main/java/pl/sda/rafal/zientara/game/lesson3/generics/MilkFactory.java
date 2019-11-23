package pl.sda.rafal.zientara.game.lesson3.generics;

import pl.sda.rafal.zientara.game.lesson3.generics.farm.OldMcDonaldFarm;
import pl.sda.rafal.zientara.game.lesson3.generics.farm.animals.Cow;

public class MilkFactory extends OldMcDonaldFarm<Cow> {

    public int produceMilk() {
        int milkLitres = 0;
        for (Cow cow : animals) {
            milkLitres += cow.getMilk();
        }
        return milkLitres;
    }

}
