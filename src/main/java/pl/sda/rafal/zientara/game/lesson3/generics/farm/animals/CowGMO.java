package pl.sda.rafal.zientara.game.lesson3.generics.farm.animals;

public class CowGMO extends Cow {

    public CowGMO() {
        super("Turbo Mućka");
    }

    @Override
    public int getMilk() {
        return super.getMilk() * 100 + 80;
    }
}
