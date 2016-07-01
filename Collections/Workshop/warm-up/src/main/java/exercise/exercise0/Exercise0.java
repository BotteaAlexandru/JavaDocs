package exercise.exercise0;

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
        LinkedList<Integer> l = new LinkedList<Integer>();
        ListIterator<Integer> it = l.listIterator();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(10);
        // TODO Exercise #0 a) Don't forget to specify the type of the list (Integer, String etc.)

        // TODO Exercise #0 b) Iterate through the list using ListIterator and print all its elements
        while(it.hasNext()){
            System.out.print(it.next().toString() + " ");
        }
        System.out.println();

        // TODO Exercise #0 c) Iterate through the list using classic for loop and print all its elements
        for(int i = 0 ; i < l.size(); i++){
            System.out.print(l.get(i).toString() + " ");
        }
        System.out.println();

        // TODO Exercise #0 d) Iterate through the list using foreach loop and print all its elements
        for(Integer item : l){
            System.out.print(item.toString() + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        // TODO Exercise #0 e) Create a new instance of Exercise0 class and call the iterateThroughList() method
        Exercise0 e = new Exercise0();
        e.iterateThroughList();
    }
}
