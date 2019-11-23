package pl.sda.rafal.zientara.game.lesson1.psr.players;

import pl.sda.rafal.zientara.game.lesson1.psr.GameAction;

import java.util.Random;

public class RandomPlayer implements Player {
    @Override
    public GameAction chooseAction() {
        Random random = new Random();
//        int value = random.nextInt() % 3;
        GameAction[] values = GameAction.values();
        int value = random.nextInt(3);//0,1,2
        return values[value];
    }
}
