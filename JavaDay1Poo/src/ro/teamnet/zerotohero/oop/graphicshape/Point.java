package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by user on 6/30/2016.
 */
public class Point {
    int xPos, yPos;

    public Point(int aPos, int bPos){
        this.xPos = aPos;
        this.yPos = bPos;
    }
    @Override
    public boolean equals(Object other){
        if(other == null)
            return false;
        if(other instanceof Point){
            Point anotherPoint = (Point) other;
            if(this.xPos == anotherPoint.xPos && this.yPos == anotherPoint.yPos){
                return true;
            }
        }
        return false;
    }
}
