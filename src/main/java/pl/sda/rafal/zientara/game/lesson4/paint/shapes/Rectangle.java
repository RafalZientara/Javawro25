package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.fillRect(x, y, width, height);
        gc.strokeRect(x, y, width, height);
    }

    @Override
    public String convertToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RECTANGLE;");
        sb.append(x).append(";")
                .append(y).append(";")
                .append(width).append(";")
                .append(height).append(";")
                .append(getFillColor()).append(";")
                .append(getStrokeColor()).append(";");
        return sb.toString();
    }
}
