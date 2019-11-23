package pl.sda.rafal.zientara.game.lesson1.psr;

import pl.sda.rafal.zientara.game.lesson1.psr.players.Player;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public GameResult checkResult() {
        GameAction action1 = player1.chooseAction();
        GameAction action2 = player2.chooseAction();

        System.out.println("Player1:" + action1);
        System.out.println("Player2:" + action2);

        if (action1 == action2) {
            return GameResult.DRAW;
        }

        if (action1 == GameAction.ROCK && action2 == GameAction.SCISSORS ||
                action1 == GameAction.PAPER && action2 == GameAction.ROCK ||
                action1 == GameAction.SCISSORS && action2 == GameAction.PAPER) {
            return GameResult.PLAYER_1_WIN;
        }

        return GameResult.PLAYER_2_WIN;
    }
}
