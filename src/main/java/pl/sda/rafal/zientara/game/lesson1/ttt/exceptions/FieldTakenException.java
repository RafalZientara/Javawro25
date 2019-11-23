package pl.sda.rafal.zientara.game.lesson1.ttt.exceptions;

public class FieldTakenException extends RuntimeException {
    public FieldTakenException() {
    }

    public FieldTakenException(String message) {
        super(message);
    }
}
