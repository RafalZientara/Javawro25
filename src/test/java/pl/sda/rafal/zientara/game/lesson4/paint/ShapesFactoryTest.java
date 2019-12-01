package pl.sda.rafal.zientara.game.lesson4.paint;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.Rectangle;
import pl.sda.rafal.zientara.game.lesson4.paint.shapes.Shape;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ShapesFactoryTest {

    @Test
    public void testParingRectangle() {
        //given
        ShapesFactory factory = new ShapesFactory();
        String input =
                "RECT;268.0;68.0;85.0;79.0;0xffffffff;0xffffffff;";

        //when
        Shape shape = factory
                .convertToShape(input);

        //then
        assertEquals(Rectangle.class, shape.getClass());
        Rectangle rectangle = (Rectangle) shape;
        assertEquals(268, rectangle.getX());
        assertEquals(68, rectangle.getY());
        assertEquals(85, rectangle.getWidth());
        assertEquals(79, rectangle.getHeight());
        assertEquals(Color.valueOf("0xffffffff"), rectangle.getFillColor());
        assertEquals(Color.valueOf("0xffffffff"), rectangle.getStrokeColor());



    }

}