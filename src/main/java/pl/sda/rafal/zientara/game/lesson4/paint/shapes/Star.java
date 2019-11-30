package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Star extends Shape{
    private double x;
    private double y;
    private double d;

    public Star(double x, double y, double wight, double height) {
        d = Math.min(wight,height);
        this.x = (x+x+wight)/2;
        this.y = (y+y+height)/2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());
        gc.beginPath();
        int sides = 5;
        int steps = sides * 2;

        double angleStep = Math.PI*2 / steps;
        double radius = d / 2;
        gc.moveTo(x,y-radius);
        for (int i = 0; i <steps ; i++) {
            double currentRadius;
            if(i%2==1){
                currentRadius = radius/2;
            }else{
                currentRadius = radius;
            }
            double sin = Math.sin(angleStep*i);
            double cos = Math.cos(angleStep*i);
            double x = this.x + currentRadius * sin;
            double y = this.y-currentRadius * cos;
            gc.lineTo(x,y);
        }

        gc.lineTo(x,y-radius);
        gc.fill();
        gc.stroke();
        gc.closePath();
    }
}
