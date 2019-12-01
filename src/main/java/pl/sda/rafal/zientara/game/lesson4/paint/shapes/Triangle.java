package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Triangle extends Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Triangle(double x, double y, double width, double height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        //gc.fillRect(x, y, width, height);
        //gc.strokeRect(x, y, width, height);

        gc.beginPath();
        gc.moveTo(x,y+height);
        gc.lineTo(x+width,y+height);
        gc.lineTo(x+width/2,y);
        gc.lineTo(x,y+height);

        gc.fill();
        gc.stroke();
        gc.closePath();
    }

    @Override
    public String convertToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TRIANGLE;");
        sb.append(x).append(";")
                .append(y).append(";")
                .append(width).append(";")
                .append(height).append(";")
                .append(getFillColor()).append(";")
                .append(getStrokeColor()).append(";");
        return sb.toString();
    }
}
