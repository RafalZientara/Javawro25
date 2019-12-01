package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public Line(double x, double y, double width, double height) {
        super();
        this.startX = x;
        this.startY = y;
        this.endX = width;
        this.endY = height;
    }


    @Override
    public void draw(GraphicsContext gc) {
        //gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.strokeLine(startX, startY, endX, endY);
    }

    @Override
    public String convertToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LINE;");
        sb.append(startX).append(";")
                .append(startY).append(";")
                .append(endX).append(";")
                .append(endY).append(";")
                .append(getFillColor()).append(";")
                .append(getStrokeColor()).append(";");
        return sb.toString();
    }
}
