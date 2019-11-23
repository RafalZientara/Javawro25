package pl.sda.rafal.zientara.game;

import org.junit.jupiter.api.Test;
import pl.sda.rafal.zientara.game.lesson1.psr.Game;
import pl.sda.rafal.zientara.game.lesson1.psr.GameAction;
import pl.sda.rafal.zientara.game.lesson1.psr.GameResult;
import pl.sda.rafal.zientara.game.lesson1.psr.players.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void whenActionsAreTheSameResultShouldBeDraw() {
        // given
        Player player1 = () -> GameAction.ROCK;
        Player player2 = this::getAction;
        Player player3 = new Player() {
            @Override
            public GameAction chooseAction() {
                return getAction();
            }
        };

        // when
        Game game = new Game(player1, player2);
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.DRAW, result);
    }

    private GameAction getAction() {
        return GameAction.ROCK;
    }

    @Test
    public void p1RockAndp2ScissorsResultShouldBePlayer1Win() {
        // given
        Player player1 = () -> GameAction.ROCK;
        Player player2 = () -> GameAction.SCISSORS;

        // when
        Game game = new Game(player1, player2);
        GameResult result = game.checkResult();

        // then
        assertEquals(GameResult.PLAYER_1_WIN, result);
    }

}