package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Square extends Shape{
    private double x;
    private double y;
    private double side;

    public Square(double x, double y, double wight, double height) {
        side = Math.min(wight,height);
        double xCenter = (x+x+wight)/2;
        double yCenter = (y+y+height)/2;
        this.x = xCenter-side/2;
        this.y = yCenter-side/2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.fillRect(x, y, side, side);
        gc.strokeRect(x, y, side, side);
    }
}
