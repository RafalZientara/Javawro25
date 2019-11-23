package pl.sda.rafal.zientara.game.lesson1.ttt.exceptions;

public class GameIsOverException extends RuntimeException {

    public GameIsOverException() {
    }

    public GameIsOverException(String message) {
        super(message);
    }
}
