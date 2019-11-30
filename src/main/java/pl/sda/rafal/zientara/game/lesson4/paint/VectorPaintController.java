package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.*;

import java.util.List;
import java.util.Optional;

public class VectorPaintController {

    @FXML
    private VectorCanvas canvas;
    @FXML
    private ColorPicker strokePicker;
    @FXML
    private ColorPicker fillPicker;

    private Tool currentTool = Tool.RECTANGLE;
    double startX;
    double startY;
    double endX;
    double endY;

    @FXML
    public void initialize() {
        System.out.println("Hello");
        canvas.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startX = event.getX();
                startY = event.getY();
                System.out.println("pressed = " + startX + ", " + startY);
            }
        });
        canvas.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                endX = event.getX();
                endY = event.getY();
                System.out.println("released = " + endX + ", " + endY);
                Shape shape = createModifiedShape();
                canvas.addShape(shape);
                canvas.setCurrentShape(null);
                canvas.refresh();
            }
        });
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                endX = event.getX();
                endY = event.getY();
                System.out.println("dragged = " + endX + ", " + endY);
                Shape shape = createModifiedShape();
                canvas.setCurrentShape(shape);
                canvas.refresh();
            }
        });
        canvas.refresh();
    }

    @FXML
    private void handleRectButton() {
        currentTool = Tool.RECTANGLE;
    }

    @FXML
    private void handleSquareButton() {
        currentTool = Tool.SQUARE;
    }

    @FXML
    private void handleOvalButton() {
        currentTool = Tool.OVAL;
    }

    @FXML
    private void handleLineButton() {
        currentTool = Tool.LINE;
    }

    @FXML
    private void handleTriaButton() {
        currentTool = Tool.TRIANGLE;
    }

    @FXML
    private void handleSaveButton() {
        System.out.println("SAVE");
        List<Shape> shapeList = canvas.getShapeList();
        Optional<String> output = shapeList.stream()
                .map(shape -> shape.convertToString())
                .reduce((acc, text) -> acc + "\n" + text);
        if (output.isPresent()) {
            System.out.println(output.get());
        } else {
            System.out.println("Nothing to do here");
        }
    }

    private Shape createModifiedShape() {
        Shape shape = createShape();
        shape.setFillColor(fillPicker.getValue());
        shape.setStrokeColor(strokePicker.getValue());
        return shape;
    }

    private Shape createShape() {
        double x = Math.min(startX, endX);
        double y = Math.min(startY, endY);
        double width = Math.abs(endX - startX);
        double height = Math.abs(endY - startY);
        switch (currentTool) {
            default:
            case RECTANGLE:
                return new Rectangle(x, y, width, height);
            case OVAL:
                return new Oval(x, y, width, height);
            case LINE:
                return new Line(startX, startY, endX, endY);
            case TRIANGLE:
                return new Triangle(x, y, width, height);
            case SQUARE:
                return new Star(x, y, width, height);
        }
    }
}
