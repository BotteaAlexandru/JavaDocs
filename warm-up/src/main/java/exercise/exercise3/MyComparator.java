package exercise.exercise3;

import java.util.Comparator;
import java.util.TreeSet;

public class MyComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        return ((String) o1).length() - ((String) o2).length();
    }
}
