package pl.sda.rafal.zientara.game.lesson1.ttt;

public enum FieldStatus {
    EMPTY(" "),
    X("X"),
    O("O");

    private final String status;

    FieldStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
