package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Line(double x, double y, double x2, double y2) {
        super();
        this.x1 = x;
        this.y1 = y;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());//todo powinnismy zrobic refactor i sie tego pozbyc
        gc.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public String convertToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LINE;");
        builder.append(x1).append(";");
        builder.append(y1).append(";");
        builder.append(x2).append(";");
        builder.append(y2).append(";");
        builder.append(getFillColor()).append(";");
        builder.append(getStrokeColor()).append(";");
        return builder.toString();

    }
}
