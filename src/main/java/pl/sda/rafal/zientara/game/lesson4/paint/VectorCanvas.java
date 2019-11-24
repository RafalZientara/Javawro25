package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.Shape;

public class VectorCanvas extends TextField {
    private final Canvas canvas;
    private Shape currentShape;

    public VectorCanvas() {
        setFocused(false);
//        setDisable(true);
        canvas = new Canvas(getWidth(), getHeight());
        getChildren().add(canvas);
        widthProperty().addListener(e -> canvas.setWidth(getWidth()));
        heightProperty().addListener(e -> canvas.setHeight(getHeight()));
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        refresh();
    }

    public void refresh() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
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