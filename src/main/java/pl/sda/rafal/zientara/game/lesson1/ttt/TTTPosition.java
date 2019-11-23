package pl.sda.rafal.zientara.game.lesson1.ttt;

public class TTTPosition {
    public final int column;
    public final int row;

    public TTTPosition(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString() {
        return "TTTPosition{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }
}
