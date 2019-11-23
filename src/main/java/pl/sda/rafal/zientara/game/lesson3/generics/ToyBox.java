package pl.sda.rafal.zientara.game.lesson3.generics;

import pl.sda.rafal.zientara.game.lesson3.optional.model.Toy;

public class ToyBox<F extends Toy> extends Box<F> {

    public void getAndPlay() {
//        Toy item = getItem();
        F item = getItem();
        System.out.println("Wyciągnąłem " + item.name);
        item.play();
    }

}
