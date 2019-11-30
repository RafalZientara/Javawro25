package pl.sda.rafal.zientara.game.lesson4.paint.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Star extends Shape{
    private double x;
    private double y;
    private double diameter;

    public Star(double x, double y, double width, double height){
        diameter = Math.min (width,height);
        this.x= (x+x+width)/2;
        this.y=(y+y+height)/2;


        }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.setStroke(getStrokeColor());

        gc.beginPath();
        int sides=5;
        int steps=sides*2;


        double angleStep=Math.PI*2/steps;
        double radius = diameter/2;
        gc.moveTo(x,y-radius);


        for (int i = 0; i <steps ; i++) {
            double currentRadius;
            if(i%2==1){
                currentRadius=radius/2;
            }else {
                currentRadius=radius;
            }
        double sin=Math.sin(angleStep*i);//0
            double cos=Math.cos(angleStep*i);//1
            double x= this.x+ currentRadius*sin;
            double y=this.y-currentRadius*cos;
            gc.lineTo(x,y);
            }
        gc.lineTo(x,y-radius);
        gc.fill();
        gc.stroke();
        gc.closePath();

        }


    }



