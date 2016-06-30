package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Square extends Shape {
    int side = 1;

    public Square(){
        this.side = 1;
    }

    public Square(int aSide){
        this.side = aSide;
    }

    @Override
    public double area() {
        return Math.pow(this.side,2);
    }
}
