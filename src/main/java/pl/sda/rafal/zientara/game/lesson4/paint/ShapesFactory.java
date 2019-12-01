package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.scene.paint.Color;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.*;

public class ShapesFactory {

    public Shape convertToShape(String input) {
        String[] split = input.split(";");
        switch (split[0].toLowerCase()) {
            case "line":
                return parseLine(split);
            case "oval":
                return parseOval(split);
            case "rect":
                return parseRect(split);
            case "squa":
                return parseSquare(split);
            case "star":
                return parseStar(split);
            case "tria":
                return parseTriangle(split);
        }
        return null;
    }

    private Shape parseRect(String[] split) {
        double x = getField(1, split);
        double y = getField(2, split);
        double w = getField(3, split);
        double h = getField(4, split);
        Color fillColor = Color.valueOf(split[5]);
        Color sc = Color.valueOf(split[6]);

        Rectangle rectangle = new Rectangle(x, y, w, h);
        rectangle.setFillColor(fillColor);
        rectangle.setStrokeColor(sc);
        return rectangle;
    }

    private Shape parseLine(String[] split) {
        double x = getField(1, split);
        double y = getField(2, split);
        double w = getField(3, split);
        double h = getField(4, split);
        Color fillColor = Color.valueOf(split[5]);
        Color sc = Color.valueOf(split[6]);

        Shape sh = new Line(x, y, w, h);
        sh.setFillColor(fillColor);
        sh.setStrokeColor(sc);
        return sh;
    }

    private Shape parseOval(String[] split) {
        double x = getField(1, split);
        double y = getField(2, split);
        double w = getField(3, split);
        double h = getField(4, split);
        Color fillColor = Color.valueOf(split[5]);
        Color sc = Color.valueOf(split[6]);

        Shape sh = new Oval(x, y, w, h);
        sh.setFillColor(fillColor);
        sh.setStrokeColor(sc);
        return sh;
    }

    private Shape parseSquare(String[] split) {
        double x = getField(1, split);
        double y = getField(2, split);
        double side = getField(3, split);
        Color fillColor = Color.valueOf(split[4]);
        Color sc = Color.valueOf(split[5]);

        Shape sh = new Square(x, y, side);
        sh.setFillColor(fillColor);
        sh.setStrokeColor(sc);
        return sh;
    }

    private double getField(int i, String[] split) {
        return Double.parseDouble(split[i].replace(",","."));
    }

    private Shape parseStar(String[] split) {
        double x = getField(1, split);
        double y = getField(2, split);
        double side = getField(3, split);
        Color fillColor = Color.valueOf(split[4]);
        Color sc = Color.valueOf(split[5]);

        Shape sh = new Star(x, y, side);
        sh.setFillColor(fillColor);
        sh.setStrokeColor(sc);
        return sh;
    }

    private Shape parseTriangle(String[] split) {
        double x = getField(1, split);
        double y = getField(2, split);
        double w = getField(3, split);
        double h = getField(4, split);
        Color fillColor = Color.valueOf(split[5]);
        Color sc = Color.valueOf(split[6]);

        Shape shape = new Triangle(x, y, w, h);
        shape.setFillColor(fillColor);
        shape.setStrokeColor(sc);
        return shape;
    }
}
