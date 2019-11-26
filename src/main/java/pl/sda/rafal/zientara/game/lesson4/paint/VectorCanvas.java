package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.Shape;

public class VectorCanvas extends Canvas {
    private Shape currentShape;

    public VectorCanvas() {
        setFocused(false);
        refresh();
    }

    public void refresh() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());
        //todo
        gc.setFill(Color.AQUAMARINE);
        gc.fillRect(50, 50, 100, 100);
        if (currentShape != null) {
            currentShape.draw(gc);
        }
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }
}