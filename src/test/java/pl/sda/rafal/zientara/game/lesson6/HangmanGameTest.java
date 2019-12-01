package pl.sda.rafal.zientara.game.lesson6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class HangmanGameTest {

    private HangmanGame game;

    @BeforeEach
    public void setup() {
        game = new HangmanGame();
    }

    @Test
    public void initGame() {
        //when
        game.setSecret("Ala ma kota");

        //then

        String result = game.getCurrentResult();
        assertEquals("... .. ....", result);
        assertEquals(7, game.getHP());
    }

    @Test
    public void secretWithNumbersShouldThrow() {
        //when, then
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                game.setSecret("1234567890");
            }
        });
    }

    @Test
    public void secretWithSpecialChractersShouldThrow() {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> game.setSecret("zje^#@o sie"));
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
    public void showLetterOnCorrectGuessUpperCase() {
        //given
        game.setSecret("Ala ma kota");

        //when
        game.guessLetter("a");

        //then
        String result = game.getCurrentResult();
        assertEquals("A.a .a ...a", result);
    }

    @Test
    public void showLetterOnCorrectGuessUppercaseGiveUpperCase() {
        //given
        game.setSecret("Ala ma kota");

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

        assertEquals(6, game.getHP());
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
        assertEquals(1, game.getHP());

        //when, then
        assertThrows(GameOverException.class, () -> game.guessLetter("g"));
        assertEquals(0,game.getHP());
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
        } catch (Exception e) {

        }

        //when
        assertThrows(GameOverException.class, ()->game.guessLetter("h"));
        assertEquals(0,game.getHP());
    }

    @Test
    public void win() {
        //given
        game.setSecret("Ala ma kota");

        //when
        game.guessLetter("A");
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