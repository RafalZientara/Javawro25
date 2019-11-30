package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Star extends Shape{

    private double x;
    private double y;
    private double diameter;


    public Star(double x, double y, double width, double height){
        diameter = Math.min(width,height);
        this.x = (x + x + width) /2;
        this.y =(y + y + height)/2;

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());

        gc.beginPath();
        int sides = 5;
        int steps = sides * 2;

        double step = Math.PI * 2/ steps;
        double radius = diameter /2;
        gc.moveTo(x,y - radius);
        for (int i = 0; i < steps; i++) {
            double sin = Math.sin(step * i);
            double cos = Math.cos(step * i);
            double x = this.x +radius * sin;
            double y = this.y -radius * cos;
            gc.lineTo(x,y);
        }

        gc.lineTo(x,y - radius);

        gc.stroke();
        gc.closePath();
// blavlvlal
    }
}
