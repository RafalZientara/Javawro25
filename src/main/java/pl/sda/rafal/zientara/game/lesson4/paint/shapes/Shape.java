package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
    private Color fillColor;
    private Color strokeColor;

    public Shape() {
        this(Color.DEEPPINK, Color.BLACK);
    }

    public Shape(Color fillColor, Color strokeColor) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public abstract void draw(GraphicsContext gc);
}
