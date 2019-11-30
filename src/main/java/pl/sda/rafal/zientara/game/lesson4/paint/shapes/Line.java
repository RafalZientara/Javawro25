package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x1, double y1, double x2, double y2) {
        super();
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.strokeLine(x1, y1, x2, y2);
    }
}
