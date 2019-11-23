package pl.sda.rafal.zientara.game.lesson1.psr.players;

import pl.sda.rafal.zientara.game.lesson1.psr.GameAction;

public class StonedPlayer implements Player {

    @Override
    public GameAction chooseAction() {
        return GameAction.ROCK;
    }

}
