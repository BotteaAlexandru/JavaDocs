package runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by user on 6/30/2016.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles = new Circles();
        System.out.println("Default circle area" + circles.getAreaPub());

        circles.getAreaDef();

        Canvas canvas = new Canvas();
//        System.out.println(canvas.getArea());
        Shape shape = new Circle(10);
        System.out.println("Shape(circle) area " + shape.area());

        ShapeBehaviour shapeBehaviour = new Square(10);
        System.out.println("Square area " + shapeBehaviour.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        ImmutableClass i = new ImmutableClass();



    }
}
