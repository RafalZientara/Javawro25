package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Square extends Shape{
    private double x;
    private double y;
    private double side;

    public Square (double x, double y, double width, double height){
        side = Math.min (width,height);
        double xc= (x+x+width)/2;
        double yc=(y+y+height)/2;
        this.x= xc-side/2;
        this.y= yc-side/2;

        }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.fillRect(x,y,side,side);
        gc.strokeRect(x,y,side,side);
    }
}


