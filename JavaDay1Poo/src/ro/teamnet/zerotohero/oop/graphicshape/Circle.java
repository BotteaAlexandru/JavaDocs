package ro.teamnet.zerotohero.oop.graphicshape;
import java.lang.Math.*;

/**
 * Created by user on 6/30/2016.
 */
public class Circle extends Shape{
    int xPos;
    int yPos;
    int radius;

    public Circle(){
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 1;
    }

    public Circle(int xPos){
        this.xPos = xPos;
        this.yPos = 0;
        this.radius = 1;
    }

    public Circle(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 1;
    }

    public Circle(int xPos, int yPos, int radius){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }


    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius,2);
    }

    public String toString(){
        return("center =(" + this.xPos + "," + this.yPos + ") and the radius is " + this.radius);
    }

    public void fillColor(){
        System.out.println(super.color);
    }

    public void fillColor(int aColor){
        super.setColor(aColor);
        System.out.println("Super color modified to " + super.color);
    }

    public void fillColor(float aSaturation){
        super.setSaturation(aSaturation);
        System.out.println("Super saturation modifed to " + super.saturation);
    }
}
