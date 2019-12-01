package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public abstract class VectorCanvas extends Canvas {
    private Shape currentShape;
    private List<Shape> shapeList = new ArrayList<>();

    public VectorCanvas() {
        setFocused(false);
        refresh();
    }

    public void refresh() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
        //todo
        gc.setFill(Color.AQUAMARINE);
        gc.clearRect(0,0,getHeight(), getWidth());
        gc.strokeRect(0,0,getHeight(), getWidth());


        gc.fillRect(50, 50, 100, 100);


        if (currentShape != null) {
            currentShape.draw(gc);
        }
        for (Shape shape : shapeList){
            shape.draw(gc);
        }
    }

    public void addShape(Shape newShape){
        shapeList.add(newShape);
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }


    public Shape getCurrentShape() {
        return currentShape;
    }

    public abstract String convertToString();



    }
