package exercise.exercise0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 *
 * Exercise 0: Create a List (ArrayList or LinkedList), add elements to it and print all of them using ListIterator
 *             for loop and foreach loop.
 *
 */
public class Exercise0 {

    public Exercise0(){

    }

    public void iterateThroughList(){

        // TODO Exercise #0 a) Create a list (ArrayList or LinkedList) and add elements to it
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        integerList.add(5);
        integerList.add(10);
        integerList.add(25);
        integerList.add(0);
        integerList.add(15);
        ListIterator<Integer> integerIterator = integerList.listIterator();

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        while (integerIterator.hasNext()) {
            System.out.print(integerIterator.next() +" ");
        }
        System.out.println();

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) +" ");
        }
        System.out.println();

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for (Integer integer : integerList) {
            System.out.print(integer +" ");
        }
    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method

        Exercise0 ex0 = new Exercise0();
        ex0.iterateThroughList();
    }
}
