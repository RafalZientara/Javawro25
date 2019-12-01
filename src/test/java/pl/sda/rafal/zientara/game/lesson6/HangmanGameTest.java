package pl.sda.rafal.zientara.game.lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HangmanGameTest {

    private HangmanGame game;

    @BeforeEach
    public void setup() {
        game = new HangmanGame();
    }

    @Test
    public void initGame() {
        //given
        //when
        game.setSecret("Ala ma kota");

        //then
        String result = game.getCurrentResult();
        assertEquals("... .. ....", result);
        assertEquals(7, game.getHp());
    }

    @Test
    public void secretWithNumbersShouldThrow() {
        //given
        //when
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.setSecret("Ala ma kota 7");
            }
        });
    }

    @Test
    public void secretWithSpecialCharactersShouldThrow() {
        //given
        //when
        assertThrows(IllegalArgumentException.class,
                () -> game.setSecret("zje^#@o sie"));
    }

    @Test
    public void showLetterOnCorrectGuess() {
        //given
        game.setSecret("Ala ma kota");

        //when
        game.guessLetter("o");

        //then
        String result = game.getCurrentResult();
        assertEquals("... .. .o..", result);
    }


    @Test
    public void showLetterOnCorrectGuessUppercase() {
        //given
        game.setSecret("Ala ma kota");

        //when
        game.guessLetter("a");

        //then
        String result = game.getCurrentResult();
        assertEquals("A.a .a ...a", result);
    }

    @Test
    public void showLetterOnCorrectGuessUppercaseGuess() {
        //given
        game.setSecret("Ala ma kota");
        System.out.println("a".hashCode());
        System.out.println("A".hashCode());

        //when
        game.guessLetter("A");

        //then
        String result = game.getCurrentResult();
        assertEquals("A.a .a ...a", result);
    }

    @Test
    public void getHitOnWrongGuess() {
        //given
        game.setSecret("xyz");

        //when
        game.guessLetter("a");

        //then
        assertEquals(6, game.getHp());
    }

    @Test
    public void gameOverOn7WrongGuess() {
        //given
        game.setSecret("xyz");
        game.guessLetter("a");
        game.guessLetter("b");
        game.guessLetter("c");
        game.guessLetter("d");
        game.guessLetter("e");
        game.guessLetter("f");
        assertEquals(1, game.getHp());

        //when
        assertThrows(GameOverException.class,
                () -> game.guessLetter("g"));
        assertEquals(0, game.getHp());
    }

    @Test
    public void userCantGuessAfterGameOver() {
        //given
        game.setSecret("xyz");
        game.guessLetter("a");
        game.guessLetter("b");
        game.guessLetter("c");
        game.guessLetter("d");
        game.guessLetter("e");
        game.guessLetter("f");
        try {
            game.guessLetter("g");
        } catch (GameOverException e) {
            //ignore
        }

        //when
        assertThrows(GameOverException.class,
                () -> game.guessLetter("h"));
        assertEquals(0, game.getHp());
    }

    @Test
    public void win() {
        //given
        game.setSecret("Ala ma kota");

        //when
        game.guessLetter("a");
        game.guessLetter("l");
        game.guessLetter("m");
        game.guessLetter("k");
        game.guessLetter("o");
        game.guessLetter("t");

        //then
        String result = game.getCurrentResult();
        assertEquals("Ala ma kota", result);
    }

}