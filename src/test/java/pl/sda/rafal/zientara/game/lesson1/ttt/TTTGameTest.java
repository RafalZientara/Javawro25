package pl.sda.rafal.zientara.game.lesson1.ttt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.sda.rafal.zientara.game.lesson1.ttt.exceptions.FieldTakenException;
import pl.sda.rafal.zientara.game.lesson1.ttt.exceptions.GameIsOverException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TTTGameTest {

    private TTTGame game;

    @BeforeEach
    public void setup() {
        game = new TTTGame();
    }

    @Test
    public void atBeginningFieldsAreEmpty() {
        // given
        game.printBoard();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // when
                FieldStatus field = game.getFieldStatus(i, j);

                //then
                assertEquals(FieldStatus.EMPTY, field);
            }
        }
    }

    @Test
    public void firstActionIsX() {
        // given
        // when
        game.action(0, 0);
        game.printBoard();

        // then
        assertEquals(FieldStatus.X, game.getFieldStatus(0, 0));
    }


    @Test
    public void fieldOccupied_ActionShouldThrow() {
        // given
        game.action(0, 0);
        game.printBoard();

        // when
        assertThrows(FieldTakenException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(0, 0);
            }
        });
    }

    @Test
    public void nextPlayerIsO() {
        // given
        game.action(0, 0);

        // when
        game.action(0, 1);
        game.printBoard();

        // then
        FieldStatus status = game
                .getFieldStatus(0, 1);
        assertEquals(FieldStatus.O, status);
    }

    @Test
    public void playerXWinsVertically() {
        // given
        game.action(0, 0);//x
        game.action(1, 0);//o
        game.action(0, 1);//x
        game.action(2, 0);//o
        game.action(0, 2);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        assertEquals(GameResult.WIN_X, result);
    }

    @Test
    public void playerXWinsHorizontally() {
        // given
        game.action(0, 1);//x
        game.action(0, 0);//o
        game.action(1, 1);//x
        game.action(1, 0);//o
        game.action(2, 1);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        assertEquals(GameResult.WIN_X, result);
    }

    @Test
    public void playerXWinsDiagonallyRight() {
        // given
        game.action(0, 0);//x
        game.action(1, 0);//o
        game.action(1, 1);//x
        game.action(2, 0);//o
        game.action(2, 2);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        assertEquals(GameResult.WIN_X, result);
    }

    @Test
    public void playerXWinsDiagonallyLeft() {
        // given
        game.action(2, 0);//x
        game.action(1, 0);//o
        game.action(1, 1);//x
        game.action(0, 1);//o
        game.action(0, 2);//x
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        assertEquals(GameResult.WIN_X, result);
    }

    @Test
    public void playerOWinsVertically() {
        // given
        game.action(0, 0);//x
        game.action(2, 0);//o
        game.action(1, 1);//x
        game.action(2, 2);//o
        game.action(1, 2);//x
        game.action(2, 1);//o
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        assertEquals(GameResult.WIN_O, result);
    }

    @Test
    public void cantPerformActionWhenGameEnds_shouldThrow() {
        // given
        game.action(0, 0);//x
        game.action(2, 0);//o
        game.action(1, 1);//x
        game.action(2, 2);//o
        game.action(1, 2);//x
        game.action(2, 1);//o
        game.printBoard();

        // when then
        assertThrows(GameIsOverException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.action(1, 0);
            }
        });
    }

    @Test
    public void draw() {
        // given
        game.action(0,0);//x 1
        game.action(1,1);//o 2
        game.action(0,1);//x 3
        game.action(0,2);//o 4
        game.action(2,0);//x 5
        game.action(1,0);//o 6
        game.action(1,2);//x 7
        game.action(2,1);//o 8
        game.action(2,2);//x 9
        game.printBoard();

        // when
        GameResult result = game.checkResult();

        assertEquals(GameResult.DRAW, result);
    }

    //todo win with last move

}